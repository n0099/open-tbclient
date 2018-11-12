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
    private View dKo;
    private TextView dPD;
    private final com.baidu.tieba.NEGFeedBack.d eaF;
    private TextView eaG;
    private TextView eaH;
    private View eaI;
    private com.baidu.tieba.NEGFeedBack.e eaJ;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.eaF = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(e.h.frs_multi_delete_menu_layout, this);
        this.dPD = (TextView) findViewById(e.g.multi_del_cancel_btn);
        this.dPD.setText(e.j.cancel);
        this.eaG = (TextView) findViewById(e.g.multi_del_btn);
        this.eaG.setText(e.j.delete);
        this.eaH = (TextView) findViewById(e.g.multi_del_forbidden_btn);
        this.eaH.setText(e.j.delete_and_forbidden_one_day);
        this.dKo = findViewById(e.g.divider_top_line);
        this.eaI = findViewById(e.g.divider);
        this.dPD.setOnClickListener(this);
        this.eaG.setOnClickListener(this);
        this.eaH.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(e.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.eaG.setText(string);
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.h(this.dPD, e.d.cp_cont_b);
        al.i(this.dPD, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.eaH, e.d.cp_cont_b);
        al.i(this.eaH, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.eaG, e.d.cp_cont_h);
        al.i(this.eaG, e.f.bg_bottom_up_list_dialog_item);
        al.j(this.dKo, e.d.cp_bg_line_c);
        al.j(this.eaI, e.d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dPD) {
            com.baidu.tieba.frs.a.ayk().reset();
        } else if (view == this.eaG) {
            if (!v.I(com.baidu.tieba.frs.a.ayk().aym())) {
                TiebaStatic.log(new am("c13122").x("obj_type", 1));
                setData(1);
                oq("2");
            }
        } else if (view == this.eaH && !v.I(com.baidu.tieba.frs.a.ayk().aym())) {
            TiebaStatic.log(new am("c13122").x("obj_type", 2));
            setData(2);
            oq("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void oq(String str) {
        if (this.pageContext != null) {
            if (this.eaJ == null) {
                this.eaJ = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.eaJ.iP(str);
        }
    }

    public void aAp() {
        if (this.eaJ != null) {
            this.eaJ.Tw();
        }
    }

    public void Tt() {
        if (this.eaJ != null) {
            this.eaJ.Tt();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.eaJ == null) {
                this.eaJ = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData ayn = com.baidu.tieba.frs.a.ayk().ayn();
            if (ayn != null && ayn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ayn.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> aym = com.baidu.tieba.frs.a.ayk().aym();
            for (int i3 = 0; i3 < aym.size(); i3++) {
                jSONArray.put(aym.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cq(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.ayk().getForumId());
            this.eaJ.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            this.eaJ.setData(ahVar);
        }
    }

    public void onDestroy() {
        if (this.eaF != null) {
            this.eaF.a((d.a) null);
            this.eaF.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.eaF != null) {
            this.eaF.a(aVar);
        }
    }
}
