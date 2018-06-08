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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PhotoWallView extends FrameLayout {
    private LinearLayout avU;
    private TbImageView[] epm;
    private LinearLayout epn;
    private LinearLayout epo;
    private LinearLayout epp;
    private c epq;
    private d epr;
    private List<PhotoUrlData> eps;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.epm = new TbImageView[8];
        this.avU = null;
        this.epn = null;
        this.epo = null;
        this.epp = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epm = new TbImageView[8];
        this.avU = null;
        this.epn = null;
        this.epo = null;
        this.epp = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.epm = new TbImageView[8];
        this.avU = null;
        this.epn = null;
        this.epo = null;
        this.epp = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(d.i.photo_wall_view, (ViewGroup) null));
        this.avU = (LinearLayout) findViewById(d.g.photo_wall_container);
        this.epn = (LinearLayout) findViewById(d.g.first_line);
        this.epo = (LinearLayout) findViewById(d.g.second_line);
        this.epo.setVisibility(8);
        this.epp = (LinearLayout) findViewById(d.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(d.g.hint_text);
        this.mScreenWidth = l.ah(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.eps != null && list != null) {
            if (this.eps.size() != list.size() || list.size() == 0 || this.eps.size() == 0) {
                z = false;
            } else {
                int size = this.eps.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.eps.get(i) == null || list.get(i) == null || !this.eps.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.eps == null) {
                    this.eps = new ArrayList();
                }
                this.eps.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.eps.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.epn.removeAllViews();
        this.epo.removeAllViews();
        LinearLayout.LayoutParams nT = nT(0);
        LinearLayout.LayoutParams nT2 = nT(1);
        LinearLayout.LayoutParams nT3 = nT(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.epm[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.epm[i2] = tbImageView3;
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
                            if (PhotoWallView.this.epq != null) {
                                PhotoWallView.this.epq.a(view, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                if (PhotoWallView.this.epr != null) {
                                    PhotoWallView.this.epr.a(view, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.epn.addView(tbImageView, nT2);
                    } else if (i2 == 3) {
                        this.epn.addView(tbImageView, nT3);
                    } else {
                        this.epn.addView(tbImageView, nT);
                    }
                } else if (i2 == 4) {
                    this.epo.addView(tbImageView, nT2);
                } else if (i2 == 7) {
                    this.epo.addView(tbImageView, nT3);
                } else {
                    this.epo.addView(tbImageView, nT);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.epp.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(d.k.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(d.k.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(d.C0141d.cp_bg_line_b_1));
            } else {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(d.C0141d.cp_bg_line_c));
            }
            tbImageView4.setScaleType(ImageView.ScaleType.CENTER);
            al.c(tbImageView4, d.f.icon_group_album_add);
            tbImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoWallView.this.epq != null) {
                        PhotoWallView.this.epq.a(view, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.epn.addView(tbImageView4, nT2);
                } else if (size3 == 3) {
                    this.epn.addView(tbImageView4, nT3);
                } else {
                    this.epn.addView(tbImageView4, nT);
                }
            } else if (size3 == 4) {
                this.epo.addView(tbImageView4, nT2);
            } else if (size3 == 7) {
                this.epo.addView(tbImageView4, nT3);
            } else {
                this.epo.addView(tbImageView4, nT);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epn.getLayoutParams();
        if (this.epn.getChildCount() + this.epo.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            this.epn.setLayoutParams(layoutParams);
            this.epo.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.epn.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams nT(int i) {
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
            TbImageView tbImageView = this.epm[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.epq = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.epr = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().onModeChanged(this.avU);
    }
}
