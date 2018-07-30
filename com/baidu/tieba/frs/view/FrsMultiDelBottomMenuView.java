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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.d;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private final com.baidu.tieba.NEGFeedBack.d dKk;
    private TextView dKl;
    private TextView dKm;
    private View dKn;
    private com.baidu.tieba.NEGFeedBack.e dKo;
    private View duG;
    private TextView dzU;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.dKk = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.frs_multi_delete_menu_layout, this);
        this.dzU = (TextView) findViewById(d.g.multi_del_cancel_btn);
        this.dzU.setText(d.j.cancel);
        this.dKl = (TextView) findViewById(d.g.multi_del_btn);
        this.dKl.setText(d.j.delete);
        this.dKm = (TextView) findViewById(d.g.multi_del_forbidden_btn);
        this.dKm.setText(d.j.delete_and_forbidden_one_day);
        this.duG = findViewById(d.g.divider_top_line);
        this.dKn = findViewById(d.g.divider);
        this.dzU.setOnClickListener(this);
        this.dKl.setOnClickListener(this);
        this.dKm.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(d.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.dKl.setText(string);
    }

    public void onChangeSkinType() {
        am.j(this, d.C0140d.cp_bg_line_d);
        am.h(this.dzU, d.C0140d.cp_cont_b);
        am.i(this.dzU, d.f.bg_bottom_up_list_dialog_item);
        am.h(this.dKm, d.C0140d.cp_cont_b);
        am.i(this.dKm, d.f.bg_bottom_up_list_dialog_item);
        am.h(this.dKl, d.C0140d.cp_cont_h);
        am.i(this.dKl, d.f.bg_bottom_up_list_dialog_item);
        am.j(this.duG, d.C0140d.cp_bg_line_c);
        am.j(this.dKn, d.C0140d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dzU) {
            com.baidu.tieba.frs.a.atD().reset();
        } else if (view == this.dKl) {
            if (!w.z(com.baidu.tieba.frs.a.atD().atF())) {
                TiebaStatic.log(new an("c13122").r("obj_type", 1));
                setData(1);
                ne("2");
            }
        } else if (view == this.dKm && !w.z(com.baidu.tieba.frs.a.atD().atF())) {
            TiebaStatic.log(new an("c13122").r("obj_type", 2));
            setData(2);
            ne("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void ne(String str) {
        if (this.pageContext != null) {
            if (this.dKo == null) {
                this.dKo = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.dKo.hY(str);
        }
    }

    public void avD() {
        if (this.dKo != null) {
            this.dKo.Py();
        }
    }

    public void Pv() {
        if (this.dKo != null) {
            this.dKo.Pv();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.dKo == null) {
                this.dKo = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData Ce = com.baidu.tieba.frs.a.atD().Ce();
            if (Ce != null && Ce.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Ce.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> atF = com.baidu.tieba.frs.a.atD().atF();
            for (int i3 = 0; i3 < atF.size(); i3++) {
                jSONArray.put(atF.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.bH(i);
            ahVar.c(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.atD().getForumId());
            this.dKo.setDefaultReasonArray(new String[]{getContext().getString(d.j.delete_thread_reason_1), getContext().getString(d.j.delete_thread_reason_2), getContext().getString(d.j.delete_thread_reason_3), getContext().getString(d.j.delete_thread_reason_4), getContext().getString(d.j.delete_thread_reason_5)});
            this.dKo.setData(ahVar);
        }
    }

    public void onDestroy() {
        if (this.dKk != null) {
            this.dKk.a((d.a) null);
            this.dKk.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.dKk != null) {
            this.dKk.a(aVar);
        }
    }
}
