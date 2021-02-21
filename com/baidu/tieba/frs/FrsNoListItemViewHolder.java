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
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FrsNoListItemViewHolder extends TypeAdapter.ViewHolder {
    public static BdUniqueId jjV = BdUniqueId.gen();
    private int fGO;
    private LinearLayout fxX;
    public TextView jjW;
    public ImageView jjX;
    private int jjY;
    private CustomMessageListener jjZ;
    private ViewGroup mParent;
    private View mRootView;
    private Rect rect;

    public FrsNoListItemViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        this.rect = new Rect();
        this.jjZ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.FrsNoListItemViewHolder.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                    FrsNoListItemViewHolder.this.rm(num.intValue());
                }
            }
        };
        this.mRootView = view;
        this.mParent = viewGroup;
        this.fxX = (LinearLayout) view.findViewById(R.id.container);
        this.jjX = (ImageView) view.findViewById(R.id.emotion_view);
        this.jjW = (TextView) view.findViewById(R.id.no_data_tips);
        com.baidu.tbadk.core.util.ap.setImageResource(this.jjX, R.drawable.new_pic_emotion_06);
        this.jjZ.setTag(jjV);
        MessageManager.getInstance().registerListener(this.jjZ);
        cEs();
    }

    private void cEs() {
        if (this.mRootView != null) {
            this.mRootView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.baidu.tieba.frs.FrsNoListItemViewHolder.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (FrsNoListItemViewHolder.this.cT(view)) {
                        FrsNoListItemViewHolder.this.rm(Integer.MAX_VALUE);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cT(View view) {
        if (view == null) {
            return false;
        }
        return view.getGlobalVisibleRect(this.rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(int i) {
        if (this.mRootView != null && this.mParent != null) {
            if (this.fGO <= 0) {
                this.fGO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            if (i != Integer.MAX_VALUE || this.jjY != Integer.MAX_VALUE) {
                this.jjY = i;
                if (this.mParent.getLocalVisibleRect(this.rect)) {
                    int i2 = this.rect.bottom;
                    int abs = Math.abs(this.fxX.getTop());
                    int abs2 = i2 - Math.abs(this.fxX.getBottom());
                    ViewGroup.LayoutParams layoutParams = this.fxX.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (abs < this.fGO) {
                            marginLayoutParams.topMargin = this.fGO;
                            this.fxX.setLayoutParams(marginLayoutParams);
                        } else if (abs == this.fGO) {
                            if (abs2 > this.fGO) {
                                marginLayoutParams.topMargin = ((abs2 - this.fGO) / 2) + this.fGO;
                                this.fxX.setLayoutParams(marginLayoutParams);
                            }
                        } else if (abs > this.fGO) {
                            if (abs2 < this.fGO) {
                                marginLayoutParams.topMargin = this.fGO;
                            } else if (abs2 == this.fGO) {
                                marginLayoutParams.topMargin = this.fGO;
                            } else if (abs2 > this.fGO) {
                                marginLayoutParams.topMargin = (abs + abs2) / 2;
                            }
                            this.fxX.setLayoutParams(marginLayoutParams);
                        }
                    }
                }
            }
        }
    }
}
