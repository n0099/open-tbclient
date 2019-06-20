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
    private final com.baidu.tieba.NEGFeedBack.d fQk;
    private TextView fQl;
    private TextView fQm;
    private View fQn;
    private com.baidu.tieba.NEGFeedBack.e fQo;
    private View fyk;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fQk = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.fDn = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.fDn.setText(R.string.cancel);
        this.fQl = (TextView) findViewById(R.id.multi_del_btn);
        this.fQl.setText(R.string.delete);
        this.fQm = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.fQm.setText(R.string.delete_and_forbidden_one_day);
        this.fyk = findViewById(R.id.divider_top_line);
        this.fQn = findViewById(R.id.divider);
        this.fDn.setOnClickListener(this);
        this.fQl.setOnClickListener(this);
        this.fQm.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fQl.setText(string);
    }

    public void onChangeSkinType() {
        al.l(this, R.color.cp_bg_line_d);
        al.j(this.fDn, R.color.cp_cont_b);
        al.k(this.fDn, R.drawable.bg_bottom_up_list_dialog_item);
        al.j(this.fQm, R.color.cp_cont_b);
        al.k(this.fQm, R.drawable.bg_bottom_up_list_dialog_item);
        al.j(this.fQl, R.color.cp_cont_h);
        al.k(this.fQl, R.drawable.bg_bottom_up_list_dialog_item);
        al.l(this.fyk, R.color.cp_bg_line_c);
        al.l(this.fQn, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fQk.registerListener();
        if (view == this.fDn) {
            com.baidu.tieba.frs.a.biW().reset();
        } else if (view == this.fQl) {
            if (!v.aa(com.baidu.tieba.frs.a.biW().biY())) {
                TiebaStatic.log(new am("c13122").P("obj_type", 1));
                setData(1);
                xg("2");
            }
        } else if (view == this.fQm && !v.aa(com.baidu.tieba.frs.a.biW().biY())) {
            TiebaStatic.log(new am("c13122").P("obj_type", 2));
            setData(2);
            xg("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void xg(String str) {
        if (this.pageContext != null) {
            if (this.fQo == null) {
                this.fQo = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fQo.rr(str);
        }
    }

    public void blk() {
        if (this.fQo != null) {
            this.fQo.aAe();
        }
    }

    public void azZ() {
        if (this.fQo != null) {
            this.fQo.azZ();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fQo == null) {
                this.fQo = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
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
            this.fQo.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.fQo.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fQk != null) {
            this.fQk.a((d.a) null);
            this.fQk.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fQk != null) {
            this.fQk.a(aVar);
        }
    }
}
