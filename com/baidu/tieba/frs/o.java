package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class o extends v.a {
    public static BdUniqueId glQ = BdUniqueId.gen();
    private LinearLayout doQ;
    private int dwM;
    public TextView glR;
    public ImageView glS;
    private int glT;
    private CustomMessageListener glU;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public o(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.glU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    o.this.ml(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.doQ = (LinearLayout) view.findViewById(R.id.container);
        this.glS = (ImageView) view.findViewById(R.id.emotion_view);
        this.glR = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.am.setImageResource(this.glS, R.drawable.new_pic_emotion_06);
        this.glU.setTag(glQ);
        MessageManager.getInstance().registerListener(this.glU);
        bCK();
    }

    private void bCK() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.o.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (o.this.bI(view)) {
                        o.this.ml(Integer.MAX_VALUE);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bI(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.dwM <= 0) {
                this.dwM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.glT != Integer.MAX_VALUE) {
                this.glT = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.doQ.getTop());
                    int abs2 = i2 - Math.abs(this.doQ.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.doQ.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.dwM) {
                            marginLayoutParams.topMargin = this.dwM;
                            this.doQ.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.dwM) {
                            if (abs2 > this.dwM) {
                                marginLayoutParams.topMargin = ((abs2 - this.dwM) / 2) + this.dwM;
                                this.doQ.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.dwM) {
                            if (abs2 < this.dwM) {
                                marginLayoutParams.topMargin = this.dwM;
                            } else if (abs2 == this.dwM) {
                                marginLayoutParams.topMargin = this.dwM;
                            } else if (abs2 > this.dwM) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.doQ.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
