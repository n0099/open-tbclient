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
    private View bEa;
    private TextView iSS;
    private final com.baidu.tieba.NEGFeedBack.d jhI;
    private TextView jhJ;
    private TextView jhK;
    private View jhL;
    private com.baidu.tieba.NEGFeedBack.e jhM;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jhI = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.iSS = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.iSS.setText(R.string.cancel);
        this.jhJ = (TextView) findViewById(R.id.multi_del_btn);
        this.jhJ.setText(R.string.delete);
        this.jhK = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jhK.setText(R.string.delete_and_forbidden_one_day);
        this.bEa = findViewById(R.id.divider_top_line);
        this.jhL = findViewById(R.id.divider);
        this.iSS.setOnClickListener(this);
        this.jhJ.setOnClickListener(this);
        this.jhK.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jhJ.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.iSS, R.color.cp_cont_b);
        ap.setBackgroundResource(this.iSS, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jhK, R.color.cp_cont_b);
        ap.setBackgroundResource(this.jhK, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jhJ, R.color.cp_cont_h);
        ap.setBackgroundResource(this.jhJ, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bEa, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jhL, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jhI.registerListener();
        if (view == this.iSS) {
            com.baidu.tieba.frs.b.cuL().reset();
        } else if (view == this.jhJ) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cuL().cuI())) {
                TiebaStatic.log(new aq("c13122").aj("obj_type", 1));
                setData(1);
                KN("2");
            }
        } else if (view == this.jhK && !y.isEmpty(com.baidu.tieba.frs.b.cuL().cuI())) {
            TiebaStatic.log(new aq("c13122").aj("obj_type", 2));
            setData(2);
            KN("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void KN(String str) {
        if (this.pageContext != null) {
            if (this.jhM == null) {
                this.jhM = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.jhM.EG(str);
        }
    }

    public void cxt() {
        if (this.jhM != null) {
            this.jhM.bGa();
        }
    }

    public void bFX() {
        if (this.jhM != null) {
            this.jhM.bFX();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jhM == null) {
                this.jhM = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cuM = com.baidu.tieba.frs.b.cuL().cuM();
            if (cuM != null && cuM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cuM.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> cuI = com.baidu.tieba.frs.b.cuL().cuI();
            for (int i3 = 0; i3 < cuI.size(); i3++) {
                jSONArray.put(cuI.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.nM(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.cuL().getForumId());
            this.jhM.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jhM.setData(arVar);
        }
    }

    public void onDestroy() {
        if (this.jhI != null) {
            this.jhI.a((d.a) null);
            this.jhI.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.jhI != null) {
            this.jhI.a(aVar);
        }
    }
}
