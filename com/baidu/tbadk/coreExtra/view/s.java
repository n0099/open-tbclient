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
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private ArrayList<String> aeo;
    private HashMap<String, ImageUrlData> aep;
    private com.baidu.tbadk.widget.g aes;
    private boolean aez;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aeq = null;
    private com.baidu.tbadk.widget.h aer = null;
    private int aet = 0;
    private boolean aeu = false;
    private String aev = null;
    private int aew = 0;
    private boolean aex = false;
    private boolean aey = false;

    public s(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.g gVar) {
        this.mContext = null;
        this.aeo = null;
        this.aes = null;
        this.mContext = context;
        this.aeo = arrayList;
        this.aes = gVar;
    }

    public void p(ArrayList<String> arrayList) {
        this.aeo = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.aep = hashMap;
    }

    public void setNextTitle(String str) {
        this.aev = str;
    }

    public void setHasNext(boolean z) {
        this.aeu = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.aeu;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aeo != null) {
            i = this.aeo.size();
            if (this.aeu) {
                i++;
            }
        }
        return i + this.aew;
    }

    public void setTempSize(int i) {
        this.aew = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aeq = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aet = i;
    }

    public void a(com.baidu.tbadk.widget.h hVar) {
        this.aer = hVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof at) {
            ((at) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.aeo.size()) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.big_image_next, null);
            ((ImageView) inflate.findViewById(com.baidu.tieba.v.image)).setImageDrawable(ba.getDrawable(com.baidu.tieba.u.big_image_next_default));
            ((TextView) inflate.findViewById(com.baidu.tieba.v.thread_name)).setText(this.aev);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        at atVar = new at(this.mContext);
        String str = i < this.aeo.size() ? this.aeo.get(i) : null;
        atVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        atVar.setImageOnClickListener(this.mOnClickListener);
        atVar.setImageOnLongClickListener(this.aeq);
        atVar.setIsCdn(this.aex);
        atVar.setOnSizeChangedListener(this.aer);
        ((ViewPager) viewGroup).addView(atVar, 0);
        atVar.setAssistUrl(dM(str));
        atVar.n(str, this.aey);
        atVar.setGifMaxUseableMem(this.aet);
        atVar.setTag(String.valueOf(i));
        atVar.setGifSetListener(this.aes);
        atVar.setHeadImage(this.aez);
        return atVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof at) {
            p pVar = (p) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((at) obj).getImageView();
            if (pVar.getSelectedView() == null) {
                pVar.setSelectedView(imageView);
                ViewParent parent = pVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = pVar.getCurrentView();
            if (imageView != currentView || i == this.aeo.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((at) obj).aH(this.aey);
                pVar.setCurrentView(imageView);
                if (((at) obj).getImageType() == 1) {
                    this.aes.a(imageView);
                }
            }
        }
    }

    private ImageUrlData dM(String str) {
        if (TextUtils.isEmpty(str) || this.aep == null) {
            return null;
        }
        return this.aep.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aey = z;
    }

    public void setIsCdn(boolean z) {
        this.aex = z;
    }

    public void setHeadImage(boolean z) {
        this.aez = z;
    }
}
