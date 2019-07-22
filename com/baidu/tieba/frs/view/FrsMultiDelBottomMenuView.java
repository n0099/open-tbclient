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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes4.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View fDg;
    private TextView fIl;
    private final com.baidu.tieba.NEGFeedBack.d fVh;
    private TextView fVi;
    private TextView fVj;
    private View fVk;
    private com.baidu.tieba.NEGFeedBack.e fVl;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fVh = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.fIl = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.fIl.setText(R.string.cancel);
        this.fVi = (TextView) findViewById(R.id.multi_del_btn);
        this.fVi.setText(R.string.delete);
        this.fVj = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.fVj.setText(R.string.delete_and_forbidden_one_day);
        this.fDg = findViewById(R.id.divider_top_line);
        this.fVk = findViewById(R.id.divider);
        this.fIl.setOnClickListener(this);
        this.fVi.setOnClickListener(this);
        this.fVj.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fVi.setText(string);
    }

    public void onChangeSkinType() {
        am.l(this, R.color.cp_bg_line_d);
        am.j(this.fIl, R.color.cp_cont_b);
        am.k(this.fIl, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.fVj, R.color.cp_cont_b);
        am.k(this.fVj, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.fVi, R.color.cp_cont_h);
        am.k(this.fVi, R.drawable.bg_bottom_up_list_dialog_item);
        am.l(this.fDg, R.color.cp_bg_line_c);
        am.l(this.fVk, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fVh.registerListener();
        if (view == this.fIl) {
            com.baidu.tieba.frs.a.bkY().reset();
        } else if (view == this.fVi) {
            if (!v.aa(com.baidu.tieba.frs.a.bkY().bla())) {
                TiebaStatic.log(new an("c13122").P("obj_type", 1));
                setData(1);
                xL("2");
            }
        } else if (view == this.fVj && !v.aa(com.baidu.tieba.frs.a.bkY().bla())) {
            TiebaStatic.log(new an("c13122").P("obj_type", 2));
            setData(2);
            xL("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void xL(String str) {
        if (this.pageContext != null) {
            if (this.fVl == null) {
                this.fVl = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fVl.rJ(str);
        }
    }

    public void bnl() {
        if (this.fVl != null) {
            this.fVl.aBs();
        }
    }

    public void aBn() {
        if (this.fVl != null) {
            this.fVl.aBn();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fVl == null) {
                this.fVl = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData blb = com.baidu.tieba.frs.a.bkY().blb();
            if (blb != null && blb.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = blb.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bg> bla = com.baidu.tieba.frs.a.bkY().bla();
            for (int i3 = 0; i3 < bla.size(); i3++) {
                jSONArray.put(bla.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gW(i);
            ajVar.x(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.bkY().getForumId());
            this.fVl.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.fVl.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fVh != null) {
            this.fVh.a((d.a) null);
            this.fVh.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fVh != null) {
            this.fVh.a(aVar);
        }
    }
}
