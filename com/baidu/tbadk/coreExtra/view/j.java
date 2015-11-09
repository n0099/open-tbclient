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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private ArrayList<String> ajX;
    private HashMap<String, ImageUrlData> ajY;
    private a.d akb;
    private List<a> akh;
    private z.b akk;
    private boolean akl;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener ajZ = null;
    private a.e aka = null;
    private int akc = 0;
    private boolean akd = false;
    private String ake = null;
    private int akf = 0;
    private int akg = 0;
    private boolean aki = false;
    private boolean akj = false;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public j(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.ajX = null;
        this.akb = null;
        this.akh = null;
        this.mContext = context;
        this.ajX = arrayList;
        this.akb = dVar;
        this.akh = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.ajX = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.ajY = hashMap;
    }

    public void setNextTitle(String str) {
        this.ake = str;
    }

    public void setHasNext(boolean z) {
        this.akd = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.akh.add(aVar);
    }

    public boolean getHasNext() {
        return this.akd;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.ajX != null) {
            i = this.ajX.size();
            if (this.akd) {
                i++;
            }
        }
        return i + this.akf + this.akg;
    }

    public void setTempSize(int i) {
        this.akf = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.akg = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajZ = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.akc = i;
    }

    public void a(a.e eVar) {
        this.aka = eVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof z) {
            ((z) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.akh.size() != 0) {
            for (a aVar : this.akh) {
                View f = aVar.f(viewGroup, i);
                if (f != null) {
                    return f;
                }
            }
        }
        View e = e(viewGroup, i);
        if (e == null) {
            return d(viewGroup, i);
        }
        return e;
    }

    private z d(ViewGroup viewGroup, int i) {
        z zVar = new z(this.mContext);
        zVar.setOriImgSelectedCallback(this.akk);
        String str = null;
        if (i < this.ajX.size()) {
            str = this.ajX.get(i);
        }
        zVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        zVar.setImageOnClickListener(this.mOnClickListener);
        zVar.setImageOnLongClickListener(this.ajZ);
        zVar.setIsCdn(this.aki);
        zVar.setOnSizeChangedListener(this.aka);
        ((ViewPager) viewGroup).addView(zVar, 0);
        zVar.setAssistUrl(es(str));
        zVar.o(str, this.akj);
        zVar.setGifMaxUseableMem(this.akc);
        zVar.setTag(String.valueOf(i));
        zVar.setGifSetListener(this.akb);
        zVar.setHeadImage(this.akl);
        return zVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.akd && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(i.g.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(i.f.image)).setImageDrawable(an.getDrawable(i.e.big_image_next_default));
            ((TextView) inflate.findViewById(i.f.thread_name)).setText(this.ake);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof z) {
            i iVar = (i) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((z) obj).getImageView();
            if (iVar.getSelectedView() == null) {
                iVar.setSelectedView(imageView);
                ViewParent parent = iVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = iVar.getCurrentView();
            if (imageView != currentView || i == this.ajX.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((z) obj).zo();
                ((z) obj).aT(this.akj);
                iVar.setCurrentView(imageView);
                if (((z) obj).getImageType() == 1) {
                    this.akb.a(imageView);
                }
            }
        }
    }

    private ImageUrlData es(String str) {
        if (TextUtils.isEmpty(str) || this.ajY == null) {
            return null;
        }
        return this.ajY.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.akj = z;
    }

    public void setIsCdn(boolean z) {
        this.aki = z;
    }

    public void setHeadImage(boolean z) {
        this.akl = z;
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        this.akk = bVar;
    }
}
