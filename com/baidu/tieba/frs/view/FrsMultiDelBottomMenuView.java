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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes4.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView fDn;
    private final com.baidu.tieba.NEGFeedBack.d fQi;
    private TextView fQj;
    private TextView fQk;
    private View fQl;
    private com.baidu.tieba.NEGFeedBack.e fQm;
    private View fyk;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fQi = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.fDn = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.fDn.setText(R.string.cancel);
        this.fQj = (TextView) findViewById(R.id.multi_del_btn);
        this.fQj.setText(R.string.delete);
        this.fQk = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.fQk.setText(R.string.delete_and_forbidden_one_day);
        this.fyk = findViewById(R.id.divider_top_line);
        this.fQl = findViewById(R.id.divider);
        this.fDn.setOnClickListener(this);
        this.fQj.setOnClickListener(this);
        this.fQk.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fQj.setText(string);
    }

    public void onChangeSkinType() {
        al.l(this, R.color.cp_bg_line_d);
        al.j(this.fDn, R.color.cp_cont_b);
        al.k(this.fDn, R.drawable.bg_bottom_up_list_dialog_item);
        al.j(this.fQk, R.color.cp_cont_b);
        al.k(this.fQk, R.drawable.bg_bottom_up_list_dialog_item);
        al.j(this.fQj, R.color.cp_cont_h);
        al.k(this.fQj, R.drawable.bg_bottom_up_list_dialog_item);
        al.l(this.fyk, R.color.cp_bg_line_c);
        al.l(this.fQl, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fQi.registerListener();
        if (view == this.fDn) {
            com.baidu.tieba.frs.a.biW().reset();
        } else if (view == this.fQj) {
            if (!v.aa(com.baidu.tieba.frs.a.biW().biY())) {
                TiebaStatic.log(new am("c13122").P("obj_type", 1));
                setData(1);
                xe("2");
            }
        } else if (view == this.fQk && !v.aa(com.baidu.tieba.frs.a.biW().biY())) {
            TiebaStatic.log(new am("c13122").P("obj_type", 2));
            setData(2);
            xe("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void xe(String str) {
        if (this.pageContext != null) {
            if (this.fQm == null) {
                this.fQm = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fQm.rs(str);
        }
    }

    public void blk() {
        if (this.fQm != null) {
            this.fQm.aAe();
        }
    }

    public void azZ() {
        if (this.fQm != null) {
            this.fQm.azZ();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fQm == null) {
                this.fQm = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData biZ = com.baidu.tieba.frs.a.biW().biZ();
            if (biZ != null && biZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bg> biY = com.baidu.tieba.frs.a.biW().biY();
            for (int i3 = 0; i3 < biY.size(); i3++) {
                jSONArray.put(biY.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gR(i);
            ajVar.x(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.biW().getForumId());
            this.fQm.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.fQm.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fQi != null) {
            this.fQi.a((d.a) null);
            this.fQi.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fQi != null) {
            this.fQi.a(aVar);
        }
    }
}
