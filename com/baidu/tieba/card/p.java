package com.baidu.tieba.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class p implements View.OnClickListener {
    private ImageView ixA;
    private ImageView ixx;
    private View ixy;
    private EMTextView ixz;
    private Context mContext;
    private String mFrom;
    private View mRootView;
    private int mSkinType = 3;
    private View mView;

    public p(Context context) {
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_low_flows_view, (ViewGroup) null);
        this.mRootView = this.mView.findViewById(R.id.root_view);
        this.mRootView.setOnClickListener(this);
        this.ixx = (ImageView) this.mView.findViewById(R.id.img_tb_storehouse);
        this.ixy = this.mView.findViewById(R.id.view_point);
        this.ixz = (EMTextView) this.mView.findViewById(R.id.title_content);
        this.ixA = (ImageView) this.mView.findViewById(R.id.close);
        this.ixA.setClickable(true);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getView() {
        return this.mView;
    }

    public ImageView cso() {
        return this.ixA;
    }

    public void ks() {
        if (!StringUtils.isNull(TbSingleton.getInstance().getBannerText())) {
            this.ixz.setText(TbSingleton.getInstance().getBannerText());
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).og(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.ixy).og(R.string.J_X03).setBackGroundColor(R.color.CAM_X0110);
            com.baidu.tbadk.core.elementsMaven.c.br(this.ixz).nY(R.color.CAM_X0108);
            this.ixA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_close22, ap.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (i == 4) {
                WebPManager.a(this.ixx, R.drawable.pic_tiebatreasure_28_2, WebPManager.ResourceStateType.NORMAL);
            } else if (i == 1) {
                WebPManager.a(this.ixx, R.drawable.pic_tiebatreasure_28_1, WebPManager.ResourceStateType.NORMAL);
            } else {
                WebPManager.a(this.ixx, R.drawable.pic_tiebatreasure_28, WebPManager.ResourceStateType.NORMAL);
            }
        }
        this.mSkinType = i;
    }

    public void IO(String str) {
        if ("2".equals(str)) {
            com.baidu.tieba.homepage.lowFlows.d.a.aK("c14079", "0", str);
        }
        if ("1".equals(str)) {
            com.baidu.tieba.homepage.lowFlows.d.a.aK("c14079", StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId()) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        HashMap hashMap = new HashMap();
        if ("from_personaize".equals(this.mFrom)) {
            hashMap.put(LowFlowsActivityConfig.LF_USER, TbSingleton.getInstance().getLFUser());
            hashMap.put(LowFlowsActivityConfig.LF_USER_TASKID, TbSingleton.getInstance().getLFUserTaskId());
            com.baidu.tieba.homepage.lowFlows.d.a.aK("c14080", StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId()) ? "0" : TbSingleton.getInstance().getLFUserTaskId(), "1");
        } else {
            hashMap.put(LowFlowsActivityConfig.LF_USER, "1");
            com.baidu.tieba.homepage.lowFlows.d.a.aK("c14080", "0", "2");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new com.baidu.tieba.tbadkCore.data.m(this.mContext, "TreasureTrovePage", hashMap)));
    }
}
