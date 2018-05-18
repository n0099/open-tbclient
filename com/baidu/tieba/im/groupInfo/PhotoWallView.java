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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PhotoWallView extends FrameLayout {
    private LinearLayout anM;
    private TbImageView[] edX;
    private LinearLayout edY;
    private LinearLayout edZ;
    private LinearLayout eea;
    private c eeb;
    private d eec;
    private List<PhotoUrlData> eed;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.edX = new TbImageView[8];
        this.anM = null;
        this.edY = null;
        this.edZ = null;
        this.eea = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.edX = new TbImageView[8];
        this.anM = null;
        this.edY = null;
        this.edZ = null;
        this.eea = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.edX = new TbImageView[8];
        this.anM = null;
        this.edY = null;
        this.edZ = null;
        this.eea = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(d.i.photo_wall_view, (ViewGroup) null));
        this.anM = (LinearLayout) findViewById(d.g.photo_wall_container);
        this.edY = (LinearLayout) findViewById(d.g.first_line);
        this.edZ = (LinearLayout) findViewById(d.g.second_line);
        this.edZ.setVisibility(8);
        this.eea = (LinearLayout) findViewById(d.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(d.g.hint_text);
        this.mScreenWidth = l.af(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.eed != null && list != null) {
            if (this.eed.size() != list.size() || list.size() == 0 || this.eed.size() == 0) {
                z = false;
            } else {
                int size = this.eed.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.eed.get(i) == null || list.get(i) == null || !this.eed.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.eed == null) {
                    this.eed = new ArrayList();
                }
                this.eed.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.eed.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.edY.removeAllViews();
        this.edZ.removeAllViews();
        LinearLayout.LayoutParams nH = nH(0);
        LinearLayout.LayoutParams nH2 = nH(1);
        LinearLayout.LayoutParams nH3 = nH(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.edX[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.edX[i2] = tbImageView3;
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
                        public void onClick(View view2) {
                            if (PhotoWallView.this.eeb != null) {
                                PhotoWallView.this.eeb.a(view2, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view2) {
                                if (PhotoWallView.this.eec != null) {
                                    PhotoWallView.this.eec.a(view2, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.edY.addView(tbImageView, nH2);
                    } else if (i2 == 3) {
                        this.edY.addView(tbImageView, nH3);
                    } else {
                        this.edY.addView(tbImageView, nH);
                    }
                } else if (i2 == 4) {
                    this.edZ.addView(tbImageView, nH2);
                } else if (i2 == 7) {
                    this.edZ.addView(tbImageView, nH3);
                } else {
                    this.edZ.addView(tbImageView, nH);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.eea.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(d.k.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(d.k.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(d.C0126d.cp_bg_line_b_1));
            } else {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(d.C0126d.cp_bg_line_c));
            }
            tbImageView4.setScaleType(ImageView.ScaleType.CENTER);
            ak.c(tbImageView4, d.f.icon_group_album_add);
            tbImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PhotoWallView.this.eeb != null) {
                        PhotoWallView.this.eeb.a(view2, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.edY.addView(tbImageView4, nH2);
                } else if (size3 == 3) {
                    this.edY.addView(tbImageView4, nH3);
                } else {
                    this.edY.addView(tbImageView4, nH);
                }
            } else if (size3 == 4) {
                this.edZ.addView(tbImageView4, nH2);
            } else if (size3 == 7) {
                this.edZ.addView(tbImageView4, nH3);
            } else {
                this.edZ.addView(tbImageView4, nH);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.edY.getLayoutParams();
        if (this.edY.getChildCount() + this.edZ.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            this.edY.setLayoutParams(layoutParams);
            this.edZ.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.edY.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams nH(int i) {
        LinearLayout.LayoutParams layoutParams;
        int e = l.e(this.mContext, d.e.ds54);
        int i2 = (this.mScreenWidth - e) / 4;
        if (this.mScreenWidth - e <= 0) {
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
            TbImageView tbImageView = this.edX[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.eeb = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.eec = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().u(this.anM);
    }
}
