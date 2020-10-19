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
    private View bBe;
    private TextView iGw;
    private final com.baidu.tieba.NEGFeedBack.d iVm;
    private TextView iVn;
    private TextView iVo;
    private View iVp;
    private com.baidu.tieba.NEGFeedBack.e iVq;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.iVm = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.iGw = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.iGw.setText(R.string.cancel);
        this.iVn = (TextView) findViewById(R.id.multi_del_btn);
        this.iVn.setText(R.string.delete);
        this.iVo = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.iVo.setText(R.string.delete_and_forbidden_one_day);
        this.bBe = findViewById(R.id.divider_top_line);
        this.iVp = findViewById(R.id.divider);
        this.iGw.setOnClickListener(this);
        this.iVn.setOnClickListener(this);
        this.iVo.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.iVn.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.iGw, R.color.cp_cont_b);
        ap.setBackgroundResource(this.iGw, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iVo, R.color.cp_cont_b);
        ap.setBackgroundResource(this.iVo, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iVn, R.color.cp_cont_h);
        ap.setBackgroundResource(this.iVn, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bBe, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iVp, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.iVm.registerListener();
        if (view == this.iGw) {
            com.baidu.tieba.frs.b.crE().reset();
        } else if (view == this.iVn) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.crE().crB())) {
                TiebaStatic.log(new aq("c13122").aj("obj_type", 1));
                setData(1);
                Ko("2");
            }
        } else if (view == this.iVo && !y.isEmpty(com.baidu.tieba.frs.b.crE().crB())) {
            TiebaStatic.log(new aq("c13122").aj("obj_type", 2));
            setData(2);
            Ko("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Ko(String str) {
        if (this.pageContext != null) {
            if (this.iVq == null) {
                this.iVq = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.iVq.En(str);
        }
    }

    public void cum() {
        if (this.iVq != null) {
            this.iVq.bEh();
        }
    }

    public void bEe() {
        if (this.iVq != null) {
            this.iVq.bEe();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.iVq == null) {
                this.iVq = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData crF = com.baidu.tieba.frs.b.crE().crF();
            if (crF != null && crF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = crF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> crB = com.baidu.tieba.frs.b.crE().crB();
            for (int i3 = 0; i3 < crB.size(); i3++) {
                jSONArray.put(crB.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.nB(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.crE().getForumId());
            this.iVq.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.iVq.setData(arVar);
        }
    }

    public void onDestroy() {
        if (this.iVm != null) {
            this.iVm.a((d.a) null);
            this.iVm.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.iVm != null) {
            this.iVm.a(aVar);
        }
    }
}
