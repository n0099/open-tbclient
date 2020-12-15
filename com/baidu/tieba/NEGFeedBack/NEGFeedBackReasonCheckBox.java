package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class NEGFeedBackReasonCheckBox extends CheckBox {
    private CustomMessageListener eOd;
    private GradientDrawable fWb;
    private GradientDrawable fWc;
    private GradientDrawable fWd;
    private StateListDrawable fWe;
    private Context mContext;
    private int mSkinType;

    public NEGFeedBackReasonCheckBox(Context context) {
        super(context);
        this.mContext = null;
        this.mSkinType = 3;
        this.eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bvt();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mSkinType = 3;
        this.eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bvt();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mSkinType = 3;
        this.eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bvt();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        int dimens = l.getDimens(this.mContext, R.dimen.ds24);
        setPadding(dimens, 0, dimens, 0);
        setButtonDrawable((Drawable) null);
    }

    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            e(R.string.J_X07, l.getDimens(this.mContext, R.dimen.L_X01), R.color.CAM_X0902, R.color.CAM_X0302, R.color.CAM_X0902);
            ap.b(this, R.color.CAM_X0105, R.color.CAM_X0302, R.color.CAM_X0105);
            this.mSkinType = skinType;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.eOd);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eOd);
    }

    private void e(int i, int i2, int i3, int i4, int i5) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i).split(",")[0]);
        this.fWb = new GradientDrawable();
        this.fWb.setShape(0);
        this.fWb.setCornerRadius(parseInt);
        this.fWb.setStroke(i2, ap.getColor(i3));
        this.fWc = new GradientDrawable();
        this.fWc.setShape(0);
        this.fWc.setCornerRadius(parseInt);
        this.fWc.setStroke(i2, com.baidu.tieba.tbadkCore.c.m(ap.getColor(i4), ap.eTK));
        this.fWd = new GradientDrawable();
        this.fWd.setShape(0);
        this.fWd.setCornerRadius(parseInt);
        this.fWd.setStroke(i2, com.baidu.tieba.tbadkCore.c.m(ap.getColor(i5), ap.eTL));
        this.fWe = new StateListDrawable();
        this.fWe.addState(new int[]{16842912}, this.fWc);
        this.fWe.addState(new int[]{-16842910}, this.fWd);
        this.fWe.addState(new int[0], this.fWb);
        setBackgroundDrawable(this.fWe);
    }
}
