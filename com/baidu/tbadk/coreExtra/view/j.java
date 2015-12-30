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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private ArrayList<String> amO;
    private Map<String, ImageUrlData> amP;
    private a.d amS;
    private List<a> amY;
    private z.b anb;
    private boolean and;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener amQ = null;
    private a.e amR = null;
    private int amT = 0;
    private boolean amU = false;
    private String amV = null;
    private int amW = 0;
    private int amX = 0;
    private boolean amZ = false;
    private boolean ana = false;
    private int anc = -1;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public j(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.amO = null;
        this.amS = null;
        this.amY = null;
        this.mContext = context;
        this.amO = arrayList;
        this.amS = dVar;
        this.amY = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.amO = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.amP = map;
    }

    public void setNextTitle(String str) {
        this.amV = str;
    }

    public void setHasNext(boolean z) {
        this.amU = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.amY.add(aVar);
    }

    public boolean getHasNext() {
        return this.amU;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.amO != null) {
            i = this.amO.size();
            if (this.amU) {
                i++;
            }
        }
        return i + this.amW + this.amX;
    }

    public void setTempSize(int i) {
        this.amW = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.amX = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amQ = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.amT = i;
    }

    public void a(a.e eVar) {
        this.amR = eVar;
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
        if (this.amY.size() != 0) {
            for (a aVar : this.amY) {
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
        zVar.setOriImgSelectedCallback(this.anb);
        String str = null;
        if (i < this.amO.size()) {
            str = this.amO.get(i);
        }
        zVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        zVar.setImageOnClickListener(this.mOnClickListener);
        zVar.setImageOnLongClickListener(this.amQ);
        zVar.setIsCdn(this.amZ);
        zVar.setOnSizeChangedListener(this.amR);
        ((ViewPager) viewGroup).addView(zVar, 0);
        zVar.setAssistUrl(eF(str));
        zVar.p(str, this.ana);
        zVar.setGifMaxUseableMem(this.amT);
        zVar.setTag(String.valueOf(i));
        zVar.setGifSetListener(this.amS);
        zVar.setHeadImage(this.and);
        return zVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.amU && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(n.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(n.g.image)).setImageDrawable(as.getDrawable(n.f.big_image_next_default));
            ((TextView) inflate.findViewById(n.g.thread_name)).setText(this.amV);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        boolean z;
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof z) {
            if (this.anc == i) {
                z = false;
            } else {
                this.anc = i;
                z = true;
            }
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
            if (imageView != currentView || i == this.amO.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((z) obj).Aa();
                ((z) obj).f(this.ana, z);
                iVar.setCurrentView(imageView);
                if (((z) obj).getImageType() == 1) {
                    this.amS.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eF(String str) {
        if (TextUtils.isEmpty(str) || this.amP == null) {
            return null;
        }
        return this.amP.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.ana = z;
    }

    public void setIsCdn(boolean z) {
        this.amZ = z;
    }

    public void setHeadImage(boolean z) {
        this.and = z;
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        this.anb = bVar;
    }
}
