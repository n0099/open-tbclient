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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes22.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View bJH;
    private TextView iYP;
    private final com.baidu.tieba.NEGFeedBack.d jnH;
    private TextView jnI;
    private TextView jnJ;
    private View jnK;
    private com.baidu.tieba.NEGFeedBack.e jnL;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jnH = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.iYP = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.iYP.setText(R.string.cancel);
        this.jnI = (TextView) findViewById(R.id.multi_del_btn);
        this.jnI.setText(R.string.delete);
        this.jnJ = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jnJ.setText(R.string.delete_and_forbidden_one_day);
        this.bJH = findViewById(R.id.divider_top_line);
        this.jnK = findViewById(R.id.divider);
        this.iYP.setOnClickListener(this);
        this.jnI.setOnClickListener(this);
        this.jnJ.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jnI.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.iYP, R.color.cp_cont_b);
        ap.setBackgroundResource(this.iYP, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jnJ, R.color.cp_cont_b);
        ap.setBackgroundResource(this.jnJ, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jnI, R.color.cp_cont_h);
        ap.setBackgroundResource(this.jnI, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bJH, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jnK, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jnH.registerListener();
        if (view == this.iYP) {
            com.baidu.tieba.frs.b.cxm().reset();
        } else if (view == this.jnI) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cxm().cxj())) {
                TiebaStatic.log(new aq("c13122").al("obj_type", 1));
                setData(1);
                Le("2");
            }
        } else if (view == this.jnJ && !y.isEmpty(com.baidu.tieba.frs.b.cxm().cxj())) {
            TiebaStatic.log(new aq("c13122").al("obj_type", 2));
            setData(2);
            Le("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Le(String str) {
        if (this.pageContext != null) {
            if (this.jnL == null) {
                this.jnL = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.jnL.EU(str);
        }
    }

    public void czU() {
        if (this.jnL != null) {
            this.jnL.bIz();
        }
    }

    public void bIw() {
        if (this.jnL != null) {
            this.jnL.bIw();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jnL == null) {
                this.jnL = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cxn = com.baidu.tieba.frs.b.cxm().cxn();
            if (cxn != null && cxn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cxn.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> cxj = com.baidu.tieba.frs.b.cxm().cxj();
            for (int i3 = 0; i3 < cxj.size(); i3++) {
                jSONArray.put(cxj.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.nW(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.cxm().getForumId());
            this.jnL.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jnL.setData(arVar);
        }
    }

    public void onDestroy() {
        if (this.jnH != null) {
            this.jnH.a((d.a) null);
            this.jnH.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.jnH != null) {
            this.jnH.a(aVar);
        }
    }
}
