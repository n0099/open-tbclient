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
    private View dTI;
    private TextView dYW;
    private final com.baidu.tieba.NEGFeedBack.d ejZ;
    private TextView eka;
    private TextView ekb;
    private View ekc;
    private com.baidu.tieba.NEGFeedBack.e ekd;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.ejZ = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(e.h.frs_multi_delete_menu_layout, this);
        this.dYW = (TextView) findViewById(e.g.multi_del_cancel_btn);
        this.dYW.setText(e.j.cancel);
        this.eka = (TextView) findViewById(e.g.multi_del_btn);
        this.eka.setText(e.j.delete);
        this.ekb = (TextView) findViewById(e.g.multi_del_forbidden_btn);
        this.ekb.setText(e.j.delete_and_forbidden_one_day);
        this.dTI = findViewById(e.g.divider_top_line);
        this.ekc = findViewById(e.g.divider);
        this.dYW.setOnClickListener(this);
        this.eka.setOnClickListener(this);
        this.ekb.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(e.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.eka.setText(string);
    }

    public void onChangeSkinType() {
        al.j(this, e.d.cp_bg_line_d);
        al.h(this.dYW, e.d.cp_cont_b);
        al.i(this.dYW, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.ekb, e.d.cp_cont_b);
        al.i(this.ekb, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.eka, e.d.cp_cont_h);
        al.i(this.eka, e.f.bg_bottom_up_list_dialog_item);
        al.j(this.dTI, e.d.cp_bg_line_c);
        al.j(this.ekc, e.d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dYW) {
            com.baidu.tieba.frs.a.aAJ().reset();
        } else if (view == this.eka) {
            if (!v.I(com.baidu.tieba.frs.a.aAJ().aAL())) {
                TiebaStatic.log(new am("c13122").x("obj_type", 1));
                setData(1);
                oS("2");
            }
        } else if (view == this.ekb && !v.I(com.baidu.tieba.frs.a.aAJ().aAL())) {
            TiebaStatic.log(new am("c13122").x("obj_type", 2));
            setData(2);
            oS("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void oS(String str) {
        if (this.pageContext != null) {
            if (this.ekd == null) {
                this.ekd = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.ekd.ji(str);
        }
    }

    public void aCO() {
        if (this.ekd != null) {
            this.ekd.UE();
        }
    }

    public void UB() {
        if (this.ekd != null) {
            this.ekd.UB();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.ekd == null) {
                this.ekd = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData aAM = com.baidu.tieba.frs.a.aAJ().aAM();
            if (aAM != null && aAM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = aAM.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> aAL = com.baidu.tieba.frs.a.aAJ().aAL();
            for (int i3 = 0; i3 < aAL.size(); i3++) {
                jSONArray.put(aAL.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.cE(i);
            ahVar.h(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.aAJ().getForumId());
            this.ekd.setDefaultReasonArray(new String[]{getContext().getString(e.j.delete_thread_reason_1), getContext().getString(e.j.delete_thread_reason_2), getContext().getString(e.j.delete_thread_reason_3), getContext().getString(e.j.delete_thread_reason_4), getContext().getString(e.j.delete_thread_reason_5)});
            this.ekd.setData(ahVar);
        }
    }

    public void onDestroy() {
        if (this.ejZ != null) {
            this.ejZ.a((d.a) null);
            this.ejZ.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.ejZ != null) {
            this.ejZ.a(aVar);
        }
    }
}
