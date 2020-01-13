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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes7.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView gAQ;
    private final com.baidu.tieba.NEGFeedBack.d gOd;
    private TextView gOe;
    private TextView gOf;
    private View gOg;
    private com.baidu.tieba.NEGFeedBack.e gOh;
    private View gvJ;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.gOd = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.gAQ = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.gAQ.setText(R.string.cancel);
        this.gOe = (TextView) findViewById(R.id.multi_del_btn);
        this.gOe.setText(R.string.delete);
        this.gOf = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.gOf.setText(R.string.delete_and_forbidden_one_day);
        this.gvJ = findViewById(R.id.divider_top_line);
        this.gOg = findViewById(R.id.divider);
        this.gAQ.setOnClickListener(this);
        this.gOe.setOnClickListener(this);
        this.gOf.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.gOe.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gAQ, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gAQ, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gOf, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gOf, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gOe, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.gOe, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.gvJ, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gOg, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gOd.registerListener();
        if (view == this.gAQ) {
            com.baidu.tieba.frs.a.bBr().reset();
        } else if (view == this.gOe) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bBr().bBt())) {
                TiebaStatic.log(new an("c13122").Z("obj_type", 1));
                setData(1);
                BC("2");
            }
        } else if (view == this.gOf && !v.isEmpty(com.baidu.tieba.frs.a.bBr().bBt())) {
            TiebaStatic.log(new an("c13122").Z("obj_type", 2));
            setData(2);
            BC("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void BC(String str) {
        if (this.pageContext != null) {
            if (this.gOh == null) {
                this.gOh = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.gOh.vS(str);
        }
    }

    public void bDI() {
        if (this.gOh != null) {
            this.gOh.aTY();
        }
    }

    public void aTV() {
        if (this.gOh != null) {
            this.gOh.aTV();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.gOh == null) {
                this.gOh = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bBu = com.baidu.tieba.frs.a.bBr().bBu();
            if (bBu != null && bBu.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bBu.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bBt = com.baidu.tieba.frs.a.bBr().bBt();
            for (int i3 = 0; i3 < bBt.size(); i3++) {
                jSONArray.put(bBt.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jg(i);
            alVar.M(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bBr().getForumId());
            this.gOh.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.gOh.setData(alVar);
        }
    }

    public void onDestroy() {
        if (this.gOd != null) {
            this.gOd.a((d.a) null);
            this.gOd.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.gOd != null) {
            this.gOd.a(aVar);
        }
    }
}
