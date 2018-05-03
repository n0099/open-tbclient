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
    private TbImageView[] ecQ;
    private LinearLayout ecR;
    private LinearLayout ecS;
    private LinearLayout ecT;
    private c ecU;
    private d ecV;
    private List<PhotoUrlData> ecW;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ecQ = new TbImageView[8];
        this.anM = null;
        this.ecR = null;
        this.ecS = null;
        this.ecT = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ecQ = new TbImageView[8];
        this.anM = null;
        this.ecR = null;
        this.ecS = null;
        this.ecT = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.ecQ = new TbImageView[8];
        this.anM = null;
        this.ecR = null;
        this.ecS = null;
        this.ecT = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(d.i.photo_wall_view, (ViewGroup) null));
        this.anM = (LinearLayout) findViewById(d.g.photo_wall_container);
        this.ecR = (LinearLayout) findViewById(d.g.first_line);
        this.ecS = (LinearLayout) findViewById(d.g.second_line);
        this.ecS.setVisibility(8);
        this.ecT = (LinearLayout) findViewById(d.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(d.g.hint_text);
        this.mScreenWidth = l.af(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.ecW != null && list != null) {
            if (this.ecW.size() != list.size() || list.size() == 0 || this.ecW.size() == 0) {
                z = false;
            } else {
                int size = this.ecW.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.ecW.get(i) == null || list.get(i) == null || !this.ecW.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.ecW == null) {
                    this.ecW = new ArrayList();
                }
                this.ecW.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.ecW.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.ecR.removeAllViews();
        this.ecS.removeAllViews();
        LinearLayout.LayoutParams nI = nI(0);
        LinearLayout.LayoutParams nI2 = nI(1);
        LinearLayout.LayoutParams nI3 = nI(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.ecQ[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.ecQ[i2] = tbImageView3;
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
                            if (PhotoWallView.this.ecU != null) {
                                PhotoWallView.this.ecU.a(view2, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view2) {
                                if (PhotoWallView.this.ecV != null) {
                                    PhotoWallView.this.ecV.a(view2, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.ecR.addView(tbImageView, nI2);
                    } else if (i2 == 3) {
                        this.ecR.addView(tbImageView, nI3);
                    } else {
                        this.ecR.addView(tbImageView, nI);
                    }
                } else if (i2 == 4) {
                    this.ecS.addView(tbImageView, nI2);
                } else if (i2 == 7) {
                    this.ecS.addView(tbImageView, nI3);
                } else {
                    this.ecS.addView(tbImageView, nI);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.ecT.setVisibility(0);
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
                    if (PhotoWallView.this.ecU != null) {
                        PhotoWallView.this.ecU.a(view2, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.ecR.addView(tbImageView4, nI2);
                } else if (size3 == 3) {
                    this.ecR.addView(tbImageView4, nI3);
                } else {
                    this.ecR.addView(tbImageView4, nI);
                }
            } else if (size3 == 4) {
                this.ecS.addView(tbImageView4, nI2);
            } else if (size3 == 7) {
                this.ecS.addView(tbImageView4, nI3);
            } else {
                this.ecS.addView(tbImageView4, nI);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ecR.getLayoutParams();
        if (this.ecR.getChildCount() + this.ecS.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            this.ecR.setLayoutParams(layoutParams);
            this.ecS.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.ecR.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams nI(int i) {
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
            TbImageView tbImageView = this.ecQ[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.ecU = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.ecV = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().u(this.anM);
    }
}
