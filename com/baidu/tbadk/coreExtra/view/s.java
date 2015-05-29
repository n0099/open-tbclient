package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private ArrayList<String> afA;
    private HashMap<String, ImageUrlData> afB;
    private com.baidu.tbadk.widget.g afE;
    private boolean afL;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener afC = null;
    private com.baidu.tbadk.widget.h afD = null;
    private int afF = 0;
    private boolean afG = false;
    private String afH = null;
    private int afI = 0;
    private boolean afJ = false;
    private boolean afK = false;

    public s(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.g gVar) {
        this.mContext = null;
        this.afA = null;
        this.afE = null;
        this.mContext = context;
        this.afA = arrayList;
        this.afE = gVar;
    }

    public void setData(ArrayList<String> arrayList) {
        this.afA = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.afB = hashMap;
    }

    public void setNextTitle(String str) {
        this.afH = str;
    }

    public void setHasNext(boolean z) {
        this.afG = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.afG;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.afA != null) {
            i = this.afA.size();
            if (this.afG) {
                i++;
            }
        }
        return i + this.afI;
    }

    public void setTempSize(int i) {
        this.afI = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afC = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.afF = i;
    }

    public void a(com.baidu.tbadk.widget.h hVar) {
        this.afD = hVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof au) {
            ((au) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.afA.size()) {
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.big_image_next, null);
            ((ImageView) inflate.findViewById(com.baidu.tieba.q.image)).setImageDrawable(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.big_image_next_default));
            ((TextView) inflate.findViewById(com.baidu.tieba.q.thread_name)).setText(this.afH);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        au auVar = new au(this.mContext);
        String str = i < this.afA.size() ? this.afA.get(i) : null;
        auVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        auVar.setImageOnClickListener(this.mOnClickListener);
        auVar.setImageOnLongClickListener(this.afC);
        auVar.setIsCdn(this.afJ);
        auVar.setOnSizeChangedListener(this.afD);
        ((ViewPager) viewGroup).addView(auVar, 0);
        auVar.setAssistUrl(eg(str));
        auVar.n(str, this.afK);
        auVar.setGifMaxUseableMem(this.afF);
        auVar.setTag(String.valueOf(i));
        auVar.setGifSetListener(this.afE);
        auVar.setHeadImage(this.afL);
        return auVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof au) {
            p pVar = (p) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((au) obj).getImageView();
            if (pVar.getSelectedView() == null) {
                pVar.setSelectedView(imageView);
                ViewParent parent = pVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = pVar.getCurrentView();
            if (imageView != currentView || i == this.afA.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((au) obj).aO(this.afK);
                pVar.setCurrentView(imageView);
                if (((au) obj).getImageType() == 1) {
                    this.afE.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eg(String str) {
        if (TextUtils.isEmpty(str) || this.afB == null) {
            return null;
        }
        return this.afB.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.afK = z;
    }

    public void setIsCdn(boolean z) {
        this.afJ = z;
    }

    public void setHeadImage(boolean z) {
        this.afL = z;
    }
}
