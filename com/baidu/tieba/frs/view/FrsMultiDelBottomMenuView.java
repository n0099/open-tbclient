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
    private View dQR;
    private TextView dWf;
    private final com.baidu.tieba.NEGFeedBack.d ehi;
    private TextView ehj;
    private TextView ehk;
    private View ehl;
    private com.baidu.tieba.NEGFeedBack.e ehm;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.ehi = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(e.h.frs_multi_delete_menu_layout, this);
        this.dWf = (TextView) findViewById(e.g.multi_del_cancel_btn);
        this.dWf.setText(e.j.cancel);
        this.ehj = (TextView) findViewById(e.g.multi_del_btn);
        this.ehj.setText(e.j.delete);
        this.ehk = (TextView) findViewById(e.g.multi_del_forbidden_btn);
        this.ehk.setText(e.j.delete_and_forbidden_one_day);
        this.dQR = findViewById(e.g.divider_top_line);
        this.ehl = findViewById(e.g.divider);
        this.dWf.setOnClickListener(this);
        this.ehj.setOnClickListener(this);
        this.ehk.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(e.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.ehj.setText(string);
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.h(this.dWf, e.d.cp_cont_b);
        al.i(this.dWf, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.ehk, e.d.cp_cont_b);
        al.i(this.ehk, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.ehj, e.d.cp_cont_h);
        al.i(this.ehj, e.f.bg_bottom_up_list_dialog_item);
        al.j(this.dQR, e.d.cp_bg_line_c);
        al.j(this.ehl, e.d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dWf) {
            com.baidu.tieba.frs.a.azU().reset();
        } else if (view == this.ehj) {
            if (!v.I(com.baidu.tieba.frs.a.azU().azW())) {
                TiebaStatic.log(new am("c13122").x("obj_type", 1));
                setData(1);
                oP("2");
            }
        } else if (view == this.ehk && !v.I(com.baidu.tieba.frs.a.azU().azW())) {
            TiebaStatic.log(new am("c13122").x("obj_type", 2));
            setData(2);
            oP("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void oP(String str) {
        if (this.pageContext != null) {
            if (this.ehm == null) {
                this.ehm = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.ehm.jh(str);
        }
    }

    public void aBZ() {
        if (this.ehm != null) {
            this.ehm.UC();
        }
    }

    public void Uz() {
        if (this.ehm != null) {
            this.ehm.Uz();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.ehm == null) {
                this.ehm = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData azX = com.baidu.tieba.frs.a.azU().azX();
            if (azX != null && azX.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = azX.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> azW = com.baidu.tieba.frs.a.azU().azW();
            for (int i3 = 0; i3 < azW.size(); i3++) {
                jSONArray.put(azW.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cE(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.azU().getForumId());
            this.ehm.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            this.ehm.setData(ahVar);
        }
    }

    public void onDestroy() {
        if (this.ehi != null) {
            this.ehi.a((d.a) null);
            this.ehi.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.ehi != null) {
            this.ehi.a(aVar);
        }
    }
}
