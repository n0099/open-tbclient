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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PhotoWallView extends FrameLayout {
    private LinearLayout aDZ;
    private TbImageView[] eLV;
    private LinearLayout eLW;
    private LinearLayout eLX;
    private LinearLayout eLY;
    private c eLZ;
    private d eMa;
    private List<PhotoUrlData> eMb;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eLV = new TbImageView[8];
        this.aDZ = null;
        this.eLW = null;
        this.eLX = null;
        this.eLY = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eLV = new TbImageView[8];
        this.aDZ = null;
        this.eLW = null;
        this.eLX = null;
        this.eLY = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.eLV = new TbImageView[8];
        this.aDZ = null;
        this.eLW = null;
        this.eLX = null;
        this.eLY = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(e.h.photo_wall_view, (ViewGroup) null));
        this.aDZ = (LinearLayout) findViewById(e.g.photo_wall_container);
        this.eLW = (LinearLayout) findViewById(e.g.first_line);
        this.eLX = (LinearLayout) findViewById(e.g.second_line);
        this.eLX.setVisibility(8);
        this.eLY = (LinearLayout) findViewById(e.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(e.g.hint_text);
        this.mScreenWidth = l.aO(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.eMb != null && list != null) {
            if (this.eMb.size() != list.size() || list.size() == 0 || this.eMb.size() == 0) {
                z = false;
            } else {
                int size = this.eMb.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.eMb.get(i) == null || list.get(i) == null || !this.eMb.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.eMb == null) {
                    this.eMb = new ArrayList();
                }
                this.eMb.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.eMb.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.eLW.removeAllViews();
        this.eLX.removeAllViews();
        LinearLayout.LayoutParams pq = pq(0);
        LinearLayout.LayoutParams pq2 = pq(1);
        LinearLayout.LayoutParams pq3 = pq(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.eLV[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.eLV[i2] = tbImageView3;
                    tbImageView = tbImageView3;
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.transparent_bg);
                tbImageView.setDefaultErrorResource(e.f.img_default_100);
                final PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(tbImageView, photoUrlData2.getSmallurl());
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PhotoWallView.this.eLZ != null) {
                                PhotoWallView.this.eLZ.a(view, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                if (PhotoWallView.this.eMa != null) {
                                    PhotoWallView.this.eMa.a(view, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.eLW.addView(tbImageView, pq2);
                    } else if (i2 == 3) {
                        this.eLW.addView(tbImageView, pq3);
                    } else {
                        this.eLW.addView(tbImageView, pq);
                    }
                } else if (i2 == 4) {
                    this.eLX.addView(tbImageView, pq2);
                } else if (i2 == 7) {
                    this.eLX.addView(tbImageView, pq3);
                } else {
                    this.eLX.addView(tbImageView, pq);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.eLY.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(e.j.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(e.j.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(e.d.cp_bg_line_b_1));
            } else {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(e.d.cp_bg_line_c));
            }
            tbImageView4.setScaleType(ImageView.ScaleType.CENTER);
            al.c(tbImageView4, e.f.icon_group_album_add);
            tbImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoWallView.this.eLZ != null) {
                        PhotoWallView.this.eLZ.a(view, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.eLW.addView(tbImageView4, pq2);
                } else if (size3 == 3) {
                    this.eLW.addView(tbImageView4, pq3);
                } else {
                    this.eLW.addView(tbImageView4, pq);
                }
            } else if (size3 == 4) {
                this.eLX.addView(tbImageView4, pq2);
            } else if (size3 == 7) {
                this.eLX.addView(tbImageView4, pq3);
            } else {
                this.eLX.addView(tbImageView4, pq);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eLW.getLayoutParams();
        if (this.eLW.getChildCount() + this.eLX.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds8);
            this.eLW.setLayoutParams(layoutParams);
            this.eLX.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.eLW.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams pq(int i) {
        LinearLayout.LayoutParams layoutParams;
        int h = l.h(this.mContext, e.C0175e.ds54);
        int i2 = (this.mScreenWidth - h) / 4;
        if (this.mScreenWidth - h <= 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
        }
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds10);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds12);
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
            TbImageView tbImageView = this.eLV[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.eLZ = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.eMa = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().onModeChanged(this.aDZ);
    }
}
