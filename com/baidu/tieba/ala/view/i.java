package com.baidu.tieba.ala.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class i {
    Context context;
    ViewGroup.LayoutParams iky;
    RelativeLayout ikz;
    ArrayList<HeadImageView> ikx = new ArrayList<>();
    boolean loop = false;
    Handler handler = new Handler(Looper.getMainLooper());
    int position = 0;

    public i(ArrayList<String> arrayList, HeadImageView headImageView, RelativeLayout relativeLayout) {
        this.iky = headImageView.getLayoutParams();
        this.context = headImageView.getContext();
        this.ikz = relativeLayout;
        headImageView.setVisibility(8);
        if (arrayList == null) {
            this.ikx.add(wG(0));
            this.ikx.add(wG(1));
            this.ikx.add(wG(0));
            this.ikx.add(wG(1));
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.ikx.add(IA(it.next()));
        }
    }

    public void sz() {
        if (!this.ikx.isEmpty()) {
            if (this.ikx.size() == 1) {
                this.ikx.get(this.position).setVisibility(0);
                return;
            }
            this.loop = true;
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.i.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.position == 0) {
                        i.this.ikx.get(i.this.position).setVisibility(0);
                        i.this.ikx.get(i.this.ikx.size() - 1).setVisibility(8);
                    } else if (i.this.position == i.this.ikx.size() - 1) {
                        i.this.ikx.get(i.this.position - 1).setVisibility(8);
                        i.this.ikx.get(i.this.position).setVisibility(0);
                        i.this.position = -1;
                    } else {
                        i.this.ikx.get(i.this.position - 1).setVisibility(8);
                        i.this.ikx.get(i.this.position).setVisibility(0);
                    }
                    i.this.position++;
                    if (i.this.loop) {
                        i.this.handler.postDelayed(this, 500L);
                        return;
                    }
                    i.this.handler.removeCallbacksAndMessages(null);
                    Iterator<HeadImageView> it = i.this.ikx.iterator();
                    while (it.hasNext()) {
                        HeadImageView next = it.next();
                        next.setVisibility(8);
                        i.this.ikz.removeView(next);
                    }
                    i.this.ikx.clear();
                }
            }, 500L);
        }
    }

    public void cmn() {
        this.handler.removeCallbacksAndMessages(null);
        this.loop = false;
        Iterator<HeadImageView> it = this.ikx.iterator();
        while (it.hasNext()) {
            HeadImageView next = it.next();
            next.setVisibility(8);
            this.ikz.removeView(next);
        }
        this.ikx.clear();
    }

    public boolean cpP() {
        return this.ikx.size() != 0;
    }

    private HeadImageView IA(String str) {
        HeadImageView headImageView = new HeadImageView(this.context);
        headImageView.startLoad(str, 25, false, false);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.ikz.addView(headImageView, this.iky);
        return headImageView;
    }

    private HeadImageView wG(int i) {
        HeadImageView headImageView = new HeadImageView(this.context);
        if (i == 0) {
            headImageView.setImageResource(a.e.ala_icon_five_pointed_star);
        } else {
            headImageView.setImageResource(a.e.ala_icon_blank_five_pointed_star);
        }
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.ikz.addView(headImageView, this.iky);
        return headImageView;
    }
}
