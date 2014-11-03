package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PhotoWallView extends FrameLayout {
    private LinearLayout Hl;
    private int atB;
    private final int bbQ;
    private TbImageView[] bbR;
    private LinearLayout bbS;
    private LinearLayout bbT;
    private LinearLayout bbU;
    private af bbV;
    private ag bbW;
    private List<PhotoUrlData> bbX;
    private boolean isManager;
    private Context mContext;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbQ = 8;
        this.bbR = new TbImageView[8];
        this.Hl = null;
        this.bbS = null;
        this.bbT = null;
        this.bbU = null;
        this.mTextView = null;
        this.atB = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbQ = 8;
        this.bbR = new TbImageView[8];
        this.Hl = null;
        this.bbS = null;
        this.bbT = null;
        this.bbU = null;
        this.mTextView = null;
        this.atB = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.bbQ = 8;
        this.bbR = new TbImageView[8];
        this.Hl = null;
        this.bbS = null;
        this.bbT = null;
        this.bbU = null;
        this.mTextView = null;
        this.atB = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.photo_wall_view, null));
        this.Hl = (LinearLayout) findViewById(com.baidu.tieba.v.photo_wall_container);
        this.bbS = (LinearLayout) findViewById(com.baidu.tieba.v.first_line);
        this.bbT = (LinearLayout) findViewById(com.baidu.tieba.v.second_line);
        this.bbT.setVisibility(8);
        this.bbU = (LinearLayout) findViewById(com.baidu.tieba.v.lay_hint_text);
        this.mTextView = (TextView) findViewById(com.baidu.tieba.v.hint_text);
        this.atB = com.baidu.adp.lib.util.m.n(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.bbX != null && list != null) {
            if (this.bbX.size() != list.size() || list.size() == 0 || this.bbX.size() == 0) {
                z = false;
            } else {
                int size = this.bbX.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.bbX.get(i) == null || list.get(i) == null || !this.bbX.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.bbX == null) {
                    this.bbX = new ArrayList();
                }
                this.bbX.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.bbX.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.bbS.removeAllViews();
        this.bbT.removeAllViews();
        LinearLayout.LayoutParams fS = fS(0);
        LinearLayout.LayoutParams fS2 = fS(1);
        LinearLayout.LayoutParams fS3 = fS(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.bbR[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.bbR[i2] = tbImageView3;
                    tbImageView = tbImageView3;
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultBg(null);
                tbImageView.setDefaultResource(0);
                tbImageView.setDefaultBgResource(0);
                aw.h(tbImageView, com.baidu.tieba.u.image_group_qzl);
                PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(tbImageView, photoUrlData2.getSmallurl());
                    tbImageView.setOnClickListener(new ah(this, photoUrlData2, i2));
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new ai(this, photoUrlData2, i2));
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.bbS.addView(tbImageView, fS2);
                    } else if (i2 == 3) {
                        this.bbS.addView(tbImageView, fS3);
                    } else {
                        this.bbS.addView(tbImageView, fS);
                    }
                } else if (i2 == 4) {
                    this.bbT.addView(tbImageView, fS2);
                } else if (i2 == 7) {
                    this.bbT.addView(tbImageView, fS3);
                } else {
                    this.bbT.addView(tbImageView, fS);
                }
            }
        }
        int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.bbU.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(com.baidu.tieba.y.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(com.baidu.tieba.y.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            tbImageView4.setImageDrawable(null);
            tbImageView4.setDefaultResource(0);
            tbImageView4.setDefaultBgResource(0);
            aw.h(tbImageView4, com.baidu.tieba.u.live_room_setting_add_selector);
            tbImageView4.setOnClickListener(new aj(this, size3));
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.bbS.addView(tbImageView4, fS2);
                } else if (size3 == 3) {
                    this.bbS.addView(tbImageView4, fS3);
                } else {
                    this.bbS.addView(tbImageView4, fS);
                }
            } else if (size3 == 4) {
                this.bbT.addView(tbImageView4, fS2);
            } else if (size3 == 7) {
                this.bbT.addView(tbImageView4, fS3);
            } else {
                this.bbT.addView(tbImageView4, fS);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbS.getLayoutParams();
        if (this.bbS.getChildCount() + this.bbT.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds8);
            this.bbS.setLayoutParams(layoutParams);
            this.bbT.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.bbS.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.c(str, 10, false);
    }

    private LinearLayout.LayoutParams fS(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_wall_per_margin) * 6;
        int i2 = (this.atB - dimensionPixelSize) / 4;
        if (this.atB - dimensionPixelSize <= 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
        }
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_wall_per_margin);
        if (i == 0) {
            layoutParams.leftMargin = dimensionPixelSize2;
            layoutParams.rightMargin = dimensionPixelSize2;
        } else if (i == 1) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = dimensionPixelSize2;
        } else if (i == 2) {
            layoutParams.leftMargin = dimensionPixelSize2;
            layoutParams.rightMargin = 0;
        }
        return layoutParams;
    }

    public void onDestory() {
        for (int i = 0; i < 8; i++) {
            TbImageView tbImageView = this.bbR[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(af afVar) {
        this.bbV = afVar;
    }

    public void setPhotoLongClickListener(ag agVar) {
        this.bbW = agVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().h(this.Hl);
    }
}
