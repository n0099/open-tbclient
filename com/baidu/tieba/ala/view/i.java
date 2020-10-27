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
/* loaded from: classes4.dex */
public class i {
    Context context;
    ViewGroup.LayoutParams hHd;
    RelativeLayout hHe;
    ArrayList<HeadImageView> hHc = new ArrayList<>();
    boolean loop = false;
    Handler handler = new Handler(Looper.getMainLooper());
    int position = 0;

    public i(ArrayList<String> arrayList, HeadImageView headImageView, RelativeLayout relativeLayout) {
        this.hHd = headImageView.getLayoutParams();
        this.context = headImageView.getContext();
        this.hHe = relativeLayout;
        headImageView.setVisibility(8);
        if (arrayList == null) {
            this.hHc.add(wx(0));
            this.hHc.add(wx(1));
            this.hHc.add(wx(0));
            this.hHc.add(wx(1));
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.hHc.add(Iy(it.next()));
        }
    }

    public void tk() {
        if (!this.hHc.isEmpty()) {
            if (this.hHc.size() == 1) {
                this.hHc.get(this.position).setVisibility(0);
                return;
            }
            this.loop = true;
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.i.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.position == 0) {
                        i.this.hHc.get(i.this.position).setVisibility(0);
                        i.this.hHc.get(i.this.hHc.size() - 1).setVisibility(8);
                    } else if (i.this.position == i.this.hHc.size() - 1) {
                        i.this.hHc.get(i.this.position - 1).setVisibility(8);
                        i.this.hHc.get(i.this.position).setVisibility(0);
                        i.this.position = -1;
                    } else {
                        i.this.hHc.get(i.this.position - 1).setVisibility(8);
                        i.this.hHc.get(i.this.position).setVisibility(0);
                    }
                    i.this.position++;
                    if (i.this.loop) {
                        i.this.handler.postDelayed(this, 500L);
                        return;
                    }
                    i.this.handler.removeCallbacksAndMessages(null);
                    Iterator<HeadImageView> it = i.this.hHc.iterator();
                    while (it.hasNext()) {
                        HeadImageView next = it.next();
                        next.setVisibility(8);
                        i.this.hHe.removeView(next);
                    }
                    i.this.hHc.clear();
                }
            }, 500L);
        }
    }

    public void cgu() {
        this.handler.removeCallbacksAndMessages(null);
        this.loop = false;
        Iterator<HeadImageView> it = this.hHc.iterator();
        while (it.hasNext()) {
            HeadImageView next = it.next();
            next.setVisibility(8);
            this.hHe.removeView(next);
        }
        this.hHc.clear();
    }

    public boolean cjq() {
        return this.hHc.size() != 0;
    }

    private HeadImageView Iy(String str) {
        HeadImageView headImageView = new HeadImageView(this.context);
        headImageView.startLoad(str, 25, false, false);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.hHe.addView(headImageView, this.hHd);
        return headImageView;
    }

    private HeadImageView wx(int i) {
        HeadImageView headImageView = new HeadImageView(this.context);
        if (i == 0) {
            headImageView.setImageResource(a.f.ala_icon_five_pointed_star);
        } else {
            headImageView.setImageResource(a.f.ala_icon_blank_five_pointed_star);
        }
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.hHe.addView(headImageView, this.hHd);
        return headImageView;
    }
}
