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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View bRR;
    private TextView jOA;
    private TextView jOB;
    private View jOC;
    private f jOD;
    private final com.baidu.tieba.NEGFeedBack.e jOz;
    private TextView jzB;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jOz = new com.baidu.tieba.NEGFeedBack.e("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.jzB = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.jzB.setText(R.string.cancel);
        this.jOA = (TextView) findViewById(R.id.multi_del_btn);
        this.jOA.setText(R.string.delete);
        this.jOB = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jOB.setText(R.string.delete_and_forbidden_one_day);
        this.bRR = findViewById(R.id.divider_top_line);
        this.jOC = findViewById(R.id.divider);
        this.jzB.setOnClickListener(this);
        this.jOA.setOnClickListener(this);
        this.jOB.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jOA.setText(string);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setViewTextColor(this.jzB, R.color.CAM_X0105);
        ao.setBackgroundResource(this.jzB, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.jOB, R.color.CAM_X0105);
        ao.setBackgroundResource(this.jOB, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.jOA, R.color.CAM_X0301);
        ao.setBackgroundResource(this.jOA, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setBackgroundColor(this.bRR, R.color.CAM_X0204);
        ao.setBackgroundColor(this.jOC, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jOz.registerListener();
        if (view == this.jzB) {
            com.baidu.tieba.frs.b.cDY().reset();
        } else if (view == this.jOA) {
            if (!x.isEmpty(com.baidu.tieba.frs.b.cDY().cDV())) {
                TiebaStatic.log(new aq("c13122").an("obj_type", 1));
                setData(1);
                LL("2");
            }
        } else if (view == this.jOB && !x.isEmpty(com.baidu.tieba.frs.b.cDY().cDV())) {
            TiebaStatic.log(new aq("c13122").an("obj_type", 2));
            setData(2);
            LL("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void LL(String str) {
        if (this.pageContext != null) {
            if (this.jOD == null) {
                this.jOD = new f(this.pageContext, this);
            }
            this.jOD.Fg(str);
        }
    }

    public void cGJ() {
        if (this.jOD != null) {
            this.jOD.bNN();
        }
    }

    public void bNJ() {
        if (this.jOD != null) {
            this.jOD.bNJ();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jOD == null) {
                this.jOD = new f(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cDZ = com.baidu.tieba.frs.b.cDY().cDZ();
            if (cDZ != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bz> cDV = com.baidu.tieba.frs.b.cDY().cDV();
            for (int i3 = 0; i3 < cDV.size(); i3++) {
                jSONArray.put(cDV.get(i3).getTid());
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray);
            atVar.oA(i);
            atVar.Q(jSONArray);
            atVar.setFid(com.baidu.tieba.frs.b.cDY().getForumId());
            this.jOD.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jOD.setData(atVar);
        }
    }

    public void onDestroy() {
        if (this.jOz != null) {
            this.jOz.a((e.a) null);
            this.jOz.onDestroy();
        }
    }

    public void setDeleteCallback(e.a aVar) {
        if (this.jOz != null) {
            this.jOz.a(aVar);
        }
    }
}
