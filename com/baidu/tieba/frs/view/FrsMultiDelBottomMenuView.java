package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.e;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes6.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View dJk;
    private TextView dOA;
    private final com.baidu.tieba.NEGFeedBack.d dZm;
    private TextView dZn;
    private TextView dZo;
    private View dZp;
    private com.baidu.tieba.NEGFeedBack.e dZq;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.dZm = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(e.h.frs_multi_delete_menu_layout, this);
        this.dOA = (TextView) findViewById(e.g.multi_del_cancel_btn);
        this.dOA.setText(e.j.cancel);
        this.dZn = (TextView) findViewById(e.g.multi_del_btn);
        this.dZn.setText(e.j.delete);
        this.dZo = (TextView) findViewById(e.g.multi_del_forbidden_btn);
        this.dZo.setText(e.j.delete_and_forbidden_one_day);
        this.dJk = findViewById(e.g.divider_top_line);
        this.dZp = findViewById(e.g.divider);
        this.dOA.setOnClickListener(this);
        this.dZn.setOnClickListener(this);
        this.dZo.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(e.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.dZn.setText(string);
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.h(this.dOA, e.d.cp_cont_b);
        al.i(this.dOA, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.dZo, e.d.cp_cont_b);
        al.i(this.dZo, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.dZn, e.d.cp_cont_h);
        al.i(this.dZn, e.f.bg_bottom_up_list_dialog_item);
        al.j(this.dJk, e.d.cp_bg_line_c);
        al.j(this.dZp, e.d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dOA) {
            com.baidu.tieba.frs.a.ayN().reset();
        } else if (view == this.dZn) {
            if (!v.J(com.baidu.tieba.frs.a.ayN().ayP())) {
                TiebaStatic.log(new am("c13122").x("obj_type", 1));
                setData(1);
                op("2");
            }
        } else if (view == this.dZo && !v.J(com.baidu.tieba.frs.a.ayN().ayP())) {
            TiebaStatic.log(new am("c13122").x("obj_type", 2));
            setData(2);
            op("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void op(String str) {
        if (this.pageContext != null) {
            if (this.dZq == null) {
                this.dZq = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.dZq.iN(str);
        }
    }

    public void aAS() {
        if (this.dZq != null) {
            this.dZq.Tn();
        }
    }

    public void Tk() {
        if (this.dZq != null) {
            this.dZq.Tk();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.dZq == null) {
                this.dZq = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData ayQ = com.baidu.tieba.frs.a.ayN().ayQ();
            if (ayQ != null && ayQ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayQ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> ayP = com.baidu.tieba.frs.a.ayN().ayP();
            for (int i3 = 0; i3 < ayP.size(); i3++) {
                jSONArray.put(ayP.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cb(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.ayN().getForumId());
            this.dZq.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            this.dZq.setData(ahVar);
        }
    }

    public void onDestroy() {
        if (this.dZm != null) {
            this.dZm.a((d.a) null);
            this.dZm.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.dZm != null) {
            this.dZm.a(aVar);
        }
    }
}
