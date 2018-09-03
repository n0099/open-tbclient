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
import com.baidu.tieba.f;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private final com.baidu.tieba.NEGFeedBack.d dKg;
    private TextView dKh;
    private TextView dKi;
    private View dKj;
    private com.baidu.tieba.NEGFeedBack.e dKk;
    private View duD;
    private TextView dzR;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.dKg = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(f.h.frs_multi_delete_menu_layout, this);
        this.dzR = (TextView) findViewById(f.g.multi_del_cancel_btn);
        this.dzR.setText(f.j.cancel);
        this.dKh = (TextView) findViewById(f.g.multi_del_btn);
        this.dKh.setText(f.j.delete);
        this.dKi = (TextView) findViewById(f.g.multi_del_forbidden_btn);
        this.dKi.setText(f.j.delete_and_forbidden_one_day);
        this.duD = findViewById(f.g.divider_top_line);
        this.dKj = findViewById(f.g.divider);
        this.dzR.setOnClickListener(this);
        this.dKh.setOnClickListener(this);
        this.dKi.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(f.j.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.dKh.setText(string);
    }

    public void onChangeSkinType() {
        am.j(this, f.d.cp_bg_line_d);
        am.h(this.dzR, f.d.cp_cont_b);
        am.i(this.dzR, f.C0146f.bg_bottom_up_list_dialog_item);
        am.h(this.dKi, f.d.cp_cont_b);
        am.i(this.dKi, f.C0146f.bg_bottom_up_list_dialog_item);
        am.h(this.dKh, f.d.cp_cont_h);
        am.i(this.dKh, f.C0146f.bg_bottom_up_list_dialog_item);
        am.j(this.duD, f.d.cp_bg_line_c);
        am.j(this.dKj, f.d.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dzR) {
            com.baidu.tieba.frs.a.atC().reset();
        } else if (view == this.dKh) {
            if (!w.z(com.baidu.tieba.frs.a.atC().atE())) {
                TiebaStatic.log(new an("c13122").r("obj_type", 1));
                setData(1);
                ng("2");
            }
        } else if (view == this.dKi && !w.z(com.baidu.tieba.frs.a.atC().atE())) {
            TiebaStatic.log(new an("c13122").r("obj_type", 2));
            setData(2);
            ng("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void ng(String str) {
        if (this.pageContext != null) {
            if (this.dKk == null) {
                this.dKk = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.dKk.hZ(str);
        }
    }

    public void avC() {
        if (this.dKk != null) {
            this.dKk.PE();
        }
    }

    public void PB() {
        if (this.dKk != null) {
            this.dKk.PB();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.dKk == null) {
                this.dKk = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData Cb = com.baidu.tieba.frs.a.atC().Cb();
            if (Cb != null && Cb.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = Cb.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bb> atE = com.baidu.tieba.frs.a.atC().atE();
            for (int i3 = 0; i3 < atE.size(); i3++) {
                jSONArray.put(atE.get(i3).getTid());
            }
            ah ahVar = new ah();
            ahVar.a(sparseArray);
            ahVar.bH(i);
            ahVar.c(jSONArray);
            ahVar.setFid(com.baidu.tieba.frs.a.atC().getForumId());
            this.dKk.setDefaultReasonArray(new String[]{getContext().getString(f.j.delete_thread_reason_1), getContext().getString(f.j.delete_thread_reason_2), getContext().getString(f.j.delete_thread_reason_3), getContext().getString(f.j.delete_thread_reason_4), getContext().getString(f.j.delete_thread_reason_5)});
            this.dKk.setData(ahVar);
        }
    }

    public void onDestroy() {
        if (this.dKg != null) {
            this.dKg.a((d.a) null);
            this.dKg.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.dKg != null) {
            this.dKg.a(aVar);
        }
    }
}
