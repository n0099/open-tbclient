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
    private LinearLayout azr;
    private TbImageView[] eEm;
    private LinearLayout eEn;
    private LinearLayout eEo;
    private LinearLayout eEp;
    private c eEq;
    private d eEr;
    private List<PhotoUrlData> eEs;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eEm = new TbImageView[8];
        this.azr = null;
        this.eEn = null;
        this.eEo = null;
        this.eEp = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eEm = new TbImageView[8];
        this.azr = null;
        this.eEn = null;
        this.eEo = null;
        this.eEp = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.eEm = new TbImageView[8];
        this.azr = null;
        this.eEn = null;
        this.eEo = null;
        this.eEp = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(e.h.photo_wall_view, (ViewGroup) null));
        this.azr = (LinearLayout) findViewById(e.g.photo_wall_container);
        this.eEn = (LinearLayout) findViewById(e.g.first_line);
        this.eEo = (LinearLayout) findViewById(e.g.second_line);
        this.eEo.setVisibility(8);
        this.eEp = (LinearLayout) findViewById(e.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(e.g.hint_text);
        this.mScreenWidth = l.aO(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.eEs != null && list != null) {
            if (this.eEs.size() != list.size() || list.size() == 0 || this.eEs.size() == 0) {
                z = false;
            } else {
                int size = this.eEs.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.eEs.get(i) == null || list.get(i) == null || !this.eEs.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.eEs == null) {
                    this.eEs = new ArrayList();
                }
                this.eEs.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.eEs.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.eEn.removeAllViews();
        this.eEo.removeAllViews();
        LinearLayout.LayoutParams oS = oS(0);
        LinearLayout.LayoutParams oS2 = oS(1);
        LinearLayout.LayoutParams oS3 = oS(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.eEm[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.eEm[i2] = tbImageView3;
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
                            if (PhotoWallView.this.eEq != null) {
                                PhotoWallView.this.eEq.a(view, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                if (PhotoWallView.this.eEr != null) {
                                    PhotoWallView.this.eEr.a(view, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.eEn.addView(tbImageView, oS2);
                    } else if (i2 == 3) {
                        this.eEn.addView(tbImageView, oS3);
                    } else {
                        this.eEn.addView(tbImageView, oS);
                    }
                } else if (i2 == 4) {
                    this.eEo.addView(tbImageView, oS2);
                } else if (i2 == 7) {
                    this.eEo.addView(tbImageView, oS3);
                } else {
                    this.eEo.addView(tbImageView, oS);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.eEp.setVisibility(0);
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
                    if (PhotoWallView.this.eEq != null) {
                        PhotoWallView.this.eEq.a(view, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.eEn.addView(tbImageView4, oS2);
                } else if (size3 == 3) {
                    this.eEn.addView(tbImageView4, oS3);
                } else {
                    this.eEn.addView(tbImageView4, oS);
                }
            } else if (size3 == 4) {
                this.eEo.addView(tbImageView4, oS2);
            } else if (size3 == 7) {
                this.eEo.addView(tbImageView4, oS3);
            } else {
                this.eEo.addView(tbImageView4, oS);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEn.getLayoutParams();
        if (this.eEn.getChildCount() + this.eEo.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds8);
            this.eEn.setLayoutParams(layoutParams);
            this.eEo.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.eEn.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams oS(int i) {
        LinearLayout.LayoutParams layoutParams;
        int h = l.h(this.mContext, e.C0141e.ds54);
        int i2 = (this.mScreenWidth - h) / 4;
        if (this.mScreenWidth - h <= 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
        }
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds10);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds12);
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
            TbImageView tbImageView = this.eEm[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.eEq = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.eEr = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().onModeChanged(this.azr);
    }
}
