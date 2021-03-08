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
/* loaded from: classes.dex */
public class NEGFeedBackReasonCheckBox extends CheckBox {
    private CustomMessageListener eXe;
    private GradientDrawable geW;
    private GradientDrawable geX;
    private GradientDrawable geY;
    private StateListDrawable geZ;
    private Context mContext;
    private int mSkinType;

    public NEGFeedBackReasonCheckBox(Context context) {
        super(context);
        this.mContext = null;
        this.mSkinType = 3;
        this.eXe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bus();
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
        this.eXe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bus();
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
        this.eXe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bus();
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

    public void bus() {
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
        MessageManager.getInstance().registerListener(this.eXe);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eXe);
    }

    private void e(int i, int i2, int i3, int i4, int i5) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i).split(",")[0]);
        this.geW = new GradientDrawable();
        this.geW.setShape(0);
        this.geW.setCornerRadius(parseInt);
        this.geW.setStroke(i2, ap.getColor(i3));
        this.geX = new GradientDrawable();
        this.geX.setShape(0);
        this.geX.setCornerRadius(parseInt);
        this.geX.setStroke(i2, com.baidu.tieba.tbadkCore.c.l(ap.getColor(i4), ap.fcm));
        this.geY = new GradientDrawable();
        this.geY.setShape(0);
        this.geY.setCornerRadius(parseInt);
        this.geY.setStroke(i2, com.baidu.tieba.tbadkCore.c.l(ap.getColor(i5), ap.fcn));
        this.geZ = new StateListDrawable();
        this.geZ.addState(new int[]{16842912}, this.geX);
        this.geZ.addState(new int[]{-16842910}, this.geY);
        this.geZ.addState(new int[0], this.geW);
        setBackgroundDrawable(this.geZ);
    }
}
