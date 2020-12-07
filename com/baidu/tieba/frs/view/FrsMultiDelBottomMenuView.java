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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes22.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View bNe;
    private final com.baidu.tieba.NEGFeedBack.e jBV;
    private TextView jBW;
    private TextView jBX;
    private View jBY;
    private com.baidu.tieba.NEGFeedBack.f jBZ;
    private TextView jnb;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jBV = new com.baidu.tieba.NEGFeedBack.e("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.jnb = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.jnb.setText(R.string.cancel);
        this.jBW = (TextView) findViewById(R.id.multi_del_btn);
        this.jBW.setText(R.string.delete);
        this.jBX = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jBX.setText(R.string.delete_and_forbidden_one_day);
        this.bNe = findViewById(R.id.divider_top_line);
        this.jBY = findViewById(R.id.divider);
        this.jnb.setOnClickListener(this);
        this.jBW.setOnClickListener(this);
        this.jBX.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jBW.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.jnb, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jnb, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jBX, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jBX, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jBW, R.color.CAM_X0301);
        ap.setBackgroundResource(this.jBW, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bNe, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jBY, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jBV.registerListener();
        if (view == this.jnb) {
            com.baidu.tieba.frs.b.cBd().reset();
        } else if (view == this.jBW) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cBd().cBa())) {
                TiebaStatic.log(new ar("c13122").al("obj_type", 1));
                setData(1);
                LM("2");
            }
        } else if (view == this.jBX && !y.isEmpty(com.baidu.tieba.frs.b.cBd().cBa())) {
            TiebaStatic.log(new ar("c13122").al("obj_type", 2));
            setData(2);
            LM("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void LM(String str) {
        if (this.pageContext != null) {
            if (this.jBZ == null) {
                this.jBZ = new com.baidu.tieba.NEGFeedBack.f(this.pageContext, this);
            }
            this.jBZ.Fj(str);
        }
    }

    public void cDN() {
        if (this.jBZ != null) {
            this.jBZ.bLt();
        }
    }

    public void bLp() {
        if (this.jBZ != null) {
            this.jBZ.bLp();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jBZ == null) {
                this.jBZ = new com.baidu.tieba.NEGFeedBack.f(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cBe = com.baidu.tieba.frs.b.cBd().cBe();
            if (cBe != null && cBe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBe.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<by> cBa = com.baidu.tieba.frs.b.cBd().cBa();
            for (int i3 = 0; i3 < cBa.size(); i3++) {
                jSONArray.put(cBa.get(i3).getTid());
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray);
            atVar.oq(i);
            atVar.Q(jSONArray);
            atVar.setFid(com.baidu.tieba.frs.b.cBd().getForumId());
            this.jBZ.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jBZ.setData(atVar);
        }
    }

    public void onDestroy() {
        if (this.jBV != null) {
            this.jBV.a((e.a) null);
            this.jBV.onDestroy();
        }
    }

    public void setDeleteCallback(e.a aVar) {
        if (this.jBV != null) {
            this.jBV.a(aVar);
        }
    }
}
