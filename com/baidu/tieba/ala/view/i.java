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
/* loaded from: classes10.dex */
public class i {
    Context context;
    ViewGroup.LayoutParams imi;
    RelativeLayout imj;
    ArrayList<HeadImageView> imh = new ArrayList<>();
    boolean loop = false;
    Handler handler = new Handler(Looper.getMainLooper());
    int position = 0;

    public i(ArrayList<String> arrayList, HeadImageView headImageView, RelativeLayout relativeLayout) {
        this.imi = headImageView.getLayoutParams();
        this.context = headImageView.getContext();
        this.imj = relativeLayout;
        headImageView.setVisibility(8);
        if (arrayList == null) {
            this.imh.add(wH(0));
            this.imh.add(wH(1));
            this.imh.add(wH(0));
            this.imh.add(wH(1));
            return;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            this.imh.add(IJ(it.next()));
        }
    }

    public void sz() {
        if (!this.imh.isEmpty()) {
            if (this.imh.size() == 1) {
                this.imh.get(this.position).setVisibility(0);
                return;
            }
            this.loop = true;
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.view.i.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i.this.position == 0) {
                        i.this.imh.get(i.this.position).setVisibility(0);
                        i.this.imh.get(i.this.imh.size() - 1).setVisibility(8);
                    } else if (i.this.position == i.this.imh.size() - 1) {
                        i.this.imh.get(i.this.position - 1).setVisibility(8);
                        i.this.imh.get(i.this.position).setVisibility(0);
                        i.this.position = -1;
                    } else {
                        i.this.imh.get(i.this.position - 1).setVisibility(8);
                        i.this.imh.get(i.this.position).setVisibility(0);
                    }
                    i.this.position++;
                    if (i.this.loop) {
                        i.this.handler.postDelayed(this, 500L);
                        return;
                    }
                    i.this.handler.removeCallbacksAndMessages(null);
                    Iterator<HeadImageView> it = i.this.imh.iterator();
                    while (it.hasNext()) {
                        HeadImageView next = it.next();
                        next.setVisibility(8);
                        i.this.imj.removeView(next);
                    }
                    i.this.imh.clear();
                }
            }, 500L);
        }
    }

    public void cmt() {
        this.handler.removeCallbacksAndMessages(null);
        this.loop = false;
        Iterator<HeadImageView> it = this.imh.iterator();
        while (it.hasNext()) {
            HeadImageView next = it.next();
            next.setVisibility(8);
            this.imj.removeView(next);
        }
        this.imh.clear();
    }

    public boolean cpV() {
        return this.imh.size() != 0;
    }

    private HeadImageView IJ(String str) {
        HeadImageView headImageView = new HeadImageView(this.context);
        headImageView.startLoad(str, 25, false, false);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.imj.addView(headImageView, this.imi);
        return headImageView;
    }

    private HeadImageView wH(int i) {
        HeadImageView headImageView = new HeadImageView(this.context);
        if (i == 0) {
            headImageView.setImageResource(a.e.ala_icon_five_pointed_star);
        } else {
            headImageView.setImageResource(a.e.ala_icon_blank_five_pointed_star);
        }
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setVisibility(8);
        this.imj.addView(headImageView, this.imi);
        return headImageView;
    }
}
