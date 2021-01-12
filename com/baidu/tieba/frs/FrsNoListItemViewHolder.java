package com.baidu.tieba.frs;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FrsNoListItemViewHolder extends TypeAdapter.ViewHolder {
    public static BdUniqueId jea = BdUniqueId.gen();
    private int fEC;
    private LinearLayout fvH;
    public TextView jeb;
    public ImageView jec;
    private int jed;
    private CustomMessageListener jee;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public FrsNoListItemViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.jee = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.FrsNoListItemViewHolder.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    FrsNoListItemViewHolder.this.rh(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.fvH = (LinearLayout) view.findViewById(R.id.container);
        this.jec = (ImageView) view.findViewById(R.id.emotion_view);
        this.jeb = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ao.setImageResource(this.jec, R.drawable.new_pic_emotion_06);
        this.jee.setTag(jea);
        MessageManager.getInstance().registerListener(this.jee);
        cCZ();
    }

    private void cCZ() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.FrsNoListItemViewHolder.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (FrsNoListItemViewHolder.this.cV(view)) {
                        FrsNoListItemViewHolder.this.rh(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cV(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.fEC <= 0) {
                this.fEC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.jed != Integer.MAX_VALUE) {
                this.jed = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.fvH.getTop());
                    int abs2 = i2 - Math.abs(this.fvH.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.fvH.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.fEC) {
                            marginLayoutParams.topMargin = this.fEC;
                            this.fvH.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.fEC) {
                            if (abs2 > this.fEC) {
                                marginLayoutParams.topMargin = ((abs2 - this.fEC) / 2) + this.fEC;
                                this.fvH.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.fEC) {
                            if (abs2 < this.fEC) {
                                marginLayoutParams.topMargin = this.fEC;
                            } else if (abs2 == this.fEC) {
                                marginLayoutParams.topMargin = this.fEC;
                            } else if (abs2 > this.fEC) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.fvH.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
