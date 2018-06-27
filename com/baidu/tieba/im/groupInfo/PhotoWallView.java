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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PhotoWallView extends FrameLayout {
    private LinearLayout awD;
    private TbImageView[] etg;
    private LinearLayout eth;
    private LinearLayout eti;
    private LinearLayout etj;
    private c etk;
    private d etl;
    private List<PhotoUrlData> etm;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etg = new TbImageView[8];
        this.awD = null;
        this.eth = null;
        this.eti = null;
        this.etj = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etg = new TbImageView[8];
        this.awD = null;
        this.eth = null;
        this.eti = null;
        this.etj = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.etg = new TbImageView[8];
        this.awD = null;
        this.eth = null;
        this.eti = null;
        this.etj = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(d.i.photo_wall_view, (ViewGroup) null));
        this.awD = (LinearLayout) findViewById(d.g.photo_wall_container);
        this.eth = (LinearLayout) findViewById(d.g.first_line);
        this.eti = (LinearLayout) findViewById(d.g.second_line);
        this.eti.setVisibility(8);
        this.etj = (LinearLayout) findViewById(d.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(d.g.hint_text);
        this.mScreenWidth = l.ah(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.etm != null && list != null) {
            if (this.etm.size() != list.size() || list.size() == 0 || this.etm.size() == 0) {
                z = false;
            } else {
                int size = this.etm.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.etm.get(i) == null || list.get(i) == null || !this.etm.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.etm == null) {
                    this.etm = new ArrayList();
                }
                this.etm.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.etm.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.eth.removeAllViews();
        this.eti.removeAllViews();
        LinearLayout.LayoutParams oa = oa(0);
        LinearLayout.LayoutParams oa2 = oa(1);
        LinearLayout.LayoutParams oa3 = oa(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.etg[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.etg[i2] = tbImageView3;
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
                            if (PhotoWallView.this.etk != null) {
                                PhotoWallView.this.etk.a(view, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                if (PhotoWallView.this.etl != null) {
                                    PhotoWallView.this.etl.a(view, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.eth.addView(tbImageView, oa2);
                    } else if (i2 == 3) {
                        this.eth.addView(tbImageView, oa3);
                    } else {
                        this.eth.addView(tbImageView, oa);
                    }
                } else if (i2 == 4) {
                    this.eti.addView(tbImageView, oa2);
                } else if (i2 == 7) {
                    this.eti.addView(tbImageView, oa3);
                } else {
                    this.eti.addView(tbImageView, oa);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.etj.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(d.k.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(d.k.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(d.C0142d.cp_bg_line_b_1));
            } else {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(d.C0142d.cp_bg_line_c));
            }
            tbImageView4.setScaleType(ImageView.ScaleType.CENTER);
            am.c(tbImageView4, d.f.icon_group_album_add);
            tbImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoWallView.this.etk != null) {
                        PhotoWallView.this.etk.a(view, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.eth.addView(tbImageView4, oa2);
                } else if (size3 == 3) {
                    this.eth.addView(tbImageView4, oa3);
                } else {
                    this.eth.addView(tbImageView4, oa);
                }
            } else if (size3 == 4) {
                this.eti.addView(tbImageView4, oa2);
            } else if (size3 == 7) {
                this.eti.addView(tbImageView4, oa3);
            } else {
                this.eti.addView(tbImageView4, oa);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eth.getLayoutParams();
        if (this.eth.getChildCount() + this.eti.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            this.eth.setLayoutParams(layoutParams);
            this.eti.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.eth.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams oa(int i) {
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
            TbImageView tbImageView = this.etg[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.etk = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.etl = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().onModeChanged(this.awD);
    }
}
