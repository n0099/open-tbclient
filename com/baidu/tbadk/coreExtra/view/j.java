package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private ArrayList<String> akZ;
    private HashMap<String, ImageUrlData> ala;
    private a.d ald;
    private boolean alk;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener alb = null;
    private a.e alc = null;
    private int ale = 0;
    private boolean alf = false;
    private String alg = null;
    private int alh = 0;
    private boolean ali = false;
    private boolean alj = false;

    public j(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.akZ = null;
        this.ald = null;
        this.mContext = context;
        this.akZ = arrayList;
        this.ald = dVar;
    }

    public void setData(ArrayList<String> arrayList) {
        this.akZ = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.ala = hashMap;
    }

    public void setNextTitle(String str) {
        this.alg = str;
    }

    public void setHasNext(boolean z) {
        this.alf = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.alf;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.akZ != null) {
            i = this.akZ.size();
            if (this.alf) {
                i++;
            }
        }
        return i + this.alh;
    }

    public void setTempSize(int i) {
        this.alh = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alb = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.ale = i;
    }

    public void a(a.e eVar) {
        this.alc = eVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof ab) {
            ((ab) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.akZ.size()) {
            View inflate = LayoutInflater.from(this.mContext).inflate(i.g.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(i.f.image)).setImageDrawable(al.getDrawable(i.e.big_image_next_default));
            ((TextView) inflate.findViewById(i.f.thread_name)).setText(this.alg);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        ab abVar = new ab(this.mContext);
        String str = i < this.akZ.size() ? this.akZ.get(i) : null;
        abVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        abVar.setImageOnClickListener(this.mOnClickListener);
        abVar.setImageOnLongClickListener(this.alb);
        abVar.setIsCdn(this.ali);
        abVar.setOnSizeChangedListener(this.alc);
        ((ViewPager) viewGroup).addView(abVar, 0);
        abVar.setAssistUrl(eq(str));
        abVar.p(str, this.alj);
        abVar.setGifMaxUseableMem(this.ale);
        abVar.setTag(String.valueOf(i));
        abVar.setGifSetListener(this.ald);
        abVar.setHeadImage(this.alk);
        return abVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof ab) {
            i iVar = (i) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((ab) obj).getImageView();
            if (iVar.getSelectedView() == null) {
                iVar.setSelectedView(imageView);
                ViewParent parent = iVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = iVar.getCurrentView();
            if (imageView != currentView || i == this.akZ.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((ab) obj).aZ(this.alj);
                iVar.setCurrentView(imageView);
                if (((ab) obj).getImageType() == 1) {
                    this.ald.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eq(String str) {
        if (TextUtils.isEmpty(str) || this.ala == null) {
            return null;
        }
        return this.ala.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.alj = z;
    }

    public void setIsCdn(boolean z) {
        this.ali = z;
    }

    public void setHeadImage(boolean z) {
        this.alk = z;
    }
}
