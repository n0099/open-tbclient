package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PhotoWallView extends FrameLayout {
    private LinearLayout bRq;
    private TbImageView[] gnB;
    private LinearLayout gnC;
    private LinearLayout gnD;
    private LinearLayout gnE;
    private c gnF;
    private d gnG;
    private List<PhotoUrlData> gnH;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnB = new TbImageView[8];
        this.bRq = null;
        this.gnC = null;
        this.gnD = null;
        this.gnE = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnB = new TbImageView[8];
        this.bRq = null;
        this.gnC = null;
        this.gnD = null;
        this.gnE = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.gnB = new TbImageView[8];
        this.bRq = null;
        this.gnC = null;
        this.gnD = null;
        this.gnE = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(d.h.photo_wall_view, (ViewGroup) null));
        this.bRq = (LinearLayout) findViewById(d.g.photo_wall_container);
        this.gnC = (LinearLayout) findViewById(d.g.first_line);
        this.gnD = (LinearLayout) findViewById(d.g.second_line);
        this.gnD.setVisibility(8);
        this.gnE = (LinearLayout) findViewById(d.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(d.g.hint_text);
        this.mScreenWidth = l.aO(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.gnH != null && list != null) {
            if (this.gnH.size() != list.size() || list.size() == 0 || this.gnH.size() == 0) {
                z = false;
            } else {
                int size = this.gnH.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.gnH.get(i) == null || list.get(i) == null || !this.gnH.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.gnH == null) {
                    this.gnH = new ArrayList();
                }
                this.gnH.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.gnH.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.gnC.removeAllViews();
        this.gnD.removeAllViews();
        LinearLayout.LayoutParams tX = tX(0);
        LinearLayout.LayoutParams tX2 = tX(1);
        LinearLayout.LayoutParams tX3 = tX(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.gnB[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.gnB[i2] = tbImageView3;
                    tbImageView = tbImageView3;
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(d.f.transparent_bg);
                tbImageView.setDefaultErrorResource(d.f.img_default_100);
                final PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(tbImageView, photoUrlData2.getSmallurl());
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PhotoWallView.this.gnF != null) {
                                PhotoWallView.this.gnF.a(view, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                if (PhotoWallView.this.gnG != null) {
                                    PhotoWallView.this.gnG.a(view, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.gnC.addView(tbImageView, tX2);
                    } else if (i2 == 3) {
                        this.gnC.addView(tbImageView, tX3);
                    } else {
                        this.gnC.addView(tbImageView, tX);
                    }
                } else if (i2 == 4) {
                    this.gnD.addView(tbImageView, tX2);
                } else if (i2 == 7) {
                    this.gnD.addView(tbImageView, tX3);
                } else {
                    this.gnD.addView(tbImageView, tX);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.gnE.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(d.j.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(d.j.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            tbImageView4.setScaleType(ImageView.ScaleType.CENTER);
            al.l(tbImageView4, d.C0277d.cp_bg_line_c);
            al.c(tbImageView4, d.f.icon_group_album_add);
            tbImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoWallView.this.gnF != null) {
                        PhotoWallView.this.gnF.a(view, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.gnC.addView(tbImageView4, tX2);
                } else if (size3 == 3) {
                    this.gnC.addView(tbImageView4, tX3);
                } else {
                    this.gnC.addView(tbImageView4, tX);
                }
            } else if (size3 == 4) {
                this.gnD.addView(tbImageView4, tX2);
            } else if (size3 == 7) {
                this.gnD.addView(tbImageView4, tX3);
            } else {
                this.gnD.addView(tbImageView4, tX);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnC.getLayoutParams();
        if (this.gnC.getChildCount() + this.gnD.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            this.gnC.setLayoutParams(layoutParams);
            this.gnD.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.gnC.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams tX(int i) {
        LinearLayout.LayoutParams layoutParams;
        int h = l.h(this.mContext, d.e.ds54);
        int i2 = (this.mScreenWidth - h) / 4;
        if (this.mScreenWidth - h <= 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
        }
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        if (i == 0) {
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = 0;
        } else if (i == 1) {
            layoutParams.leftMargin = dimensionPixelSize2;
            layoutParams.rightMargin = 0;
        } else if (i == 2) {
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize2;
        }
        return layoutParams;
    }

    public void onDestory() {
        for (int i = 0; i < 8; i++) {
            TbImageView tbImageView = this.gnB[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.gnF = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.gnG = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().onModeChanged(this.bRq);
    }
}
