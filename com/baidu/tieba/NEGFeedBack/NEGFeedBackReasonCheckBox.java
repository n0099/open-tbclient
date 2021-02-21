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
    private CustomMessageListener eVF;
    private GradientDrawable gds;
    private GradientDrawable gdt;
    private GradientDrawable gdu;
    private StateListDrawable gdv;
    private Context mContext;
    private int mSkinType;

    public NEGFeedBackReasonCheckBox(Context context) {
        super(context);
        this.mContext = null;
        this.mSkinType = 3;
        this.eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bup();
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
        this.eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bup();
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
        this.eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                    NEGFeedBackReasonCheckBox.this.bup();
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

    public void bup() {
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
        MessageManager.getInstance().registerListener(this.eVF);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.eVF);
    }

    private void e(int i, int i2, int i3, int i4, int i5) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i).split(",")[0]);
        this.gds = new GradientDrawable();
        this.gds.setShape(0);
        this.gds.setCornerRadius(parseInt);
        this.gds.setStroke(i2, ap.getColor(i3));
        this.gdt = new GradientDrawable();
        this.gdt.setShape(0);
        this.gdt.setCornerRadius(parseInt);
        this.gdt.setStroke(i2, com.baidu.tieba.tbadkCore.c.l(ap.getColor(i4), ap.faN));
        this.gdu = new GradientDrawable();
        this.gdu.setShape(0);
        this.gdu.setCornerRadius(parseInt);
        this.gdu.setStroke(i2, com.baidu.tieba.tbadkCore.c.l(ap.getColor(i5), ap.faO));
        this.gdv = new StateListDrawable();
        this.gdv.addState(new int[]{16842912}, this.gdt);
        this.gdv.addState(new int[]{-16842910}, this.gdu);
        this.gdv.addState(new int[0], this.gds);
        setBackgroundDrawable(this.gdv);
    }
}
