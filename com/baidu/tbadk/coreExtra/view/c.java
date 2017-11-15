package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private f auW;
    private Map<String, ImageUrlData> auY;
    private a.e avc;
    private List<a> avi;
    private a.d avj;
    private f.b avm;
    private boolean avn;
    private b avo;
    private boolean avp;
    private Context mContext;
    private ArrayList<String> auX = null;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener auZ = null;
    private View.OnTouchListener ava = null;
    private a.f avb = null;
    private int avd = 0;
    private boolean ave = false;
    private String avf = null;
    private int avg = 0;
    private int avh = 0;
    private boolean avk = false;
    private boolean avl = false;
    private int mPosition = -1;

    /* loaded from: classes.dex */
    public interface a {
        View e(ViewGroup viewGroup, int i);
    }

    public c(Context context, b bVar, a.e eVar) {
        this.mContext = null;
        this.avc = null;
        this.avi = null;
        this.mContext = context;
        this.avo = bVar;
        this.avc = eVar;
        this.avi = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.auX = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.auY = map;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.avf = str;
    }

    public void setHasNext(boolean z) {
        this.ave = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.avi.add(aVar);
    }

    public boolean getHasNext() {
        return this.ave;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.auX != null) {
            i = this.auX.size();
            if (this.ave) {
                i++;
            }
        }
        return i + this.avg + this.avh;
    }

    public void setTempSize(int i) {
        this.avg = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.avh = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.ava = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auZ = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.avd = i;
    }

    public void a(a.f fVar) {
        this.avb = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof f) {
            ((f) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View c = c(viewGroup, i);
        if (c == null && this.avi != null && this.avi.size() != 0) {
            Iterator<a> it = this.avi.iterator();
            while (it.hasNext() && (c = it.next().e(viewGroup, i)) == null) {
            }
        }
        if (c == null) {
            return d(viewGroup, i);
        }
        return c;
    }

    public void setIsCanDrag(boolean z) {
        this.avn = z;
    }

    private f c(ViewGroup viewGroup, int i) {
        String str = i < this.auX.size() ? this.auX.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.avm);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.auZ);
        fVar.setOuterOnTouchListener(this.ava);
        fVar.setIsCanDrag(this.avn);
        fVar.setIsCdn(this.avk);
        fVar.setOnSizeChangedListener(this.avb);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(fg(str));
        fVar.n(str, this.avl);
        fVar.setGifMaxUseableMem(this.avd);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.avc);
        fVar.setHeadImage(this.avp);
        fVar.setDragToExitListener(this.avj);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.avj = dVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.ave && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.g.image)).setImageDrawable(aj.getDrawable(d.f.big_image_next_default));
            ((TextView) inflate.findViewById(d.g.thread_name)).setText(this.avf);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.mPosition != i) {
                com.baidu.tbadk.widget.a imageView = fVar.getImageView();
                if (imageView != null) {
                    imageView.HG();
                    this.avo.setCurrentView(imageView);
                    if (imageView.getImageType() == 1) {
                        this.avc.a(imageView);
                    }
                }
                fVar.Bw();
                fVar.Bv();
                fVar.j(this.avl, true);
                this.mPosition = i;
                this.auW = fVar;
            }
        }
    }

    private ImageUrlData fg(String str) {
        if (TextUtils.isEmpty(str) || this.auY == null) {
            return null;
        }
        return this.auY.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.avl = z;
    }

    public void setIsCdn(boolean z) {
        this.avk = z;
    }

    public void setHeadImage(boolean z) {
        this.avp = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.avm = bVar;
    }
}
