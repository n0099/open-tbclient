package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ae;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.forumdetail.ForumDetailData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends ae {

    /* renamed from: a  reason: collision with root package name */
    private ForumDetailData.ThreadInfo[] f1224a;
    private LayoutInflater b;
    private Context c;

    public l(Context context, ForumDetailData.ThreadInfo[] threadInfoArr) {
        this.f1224a = threadInfoArr;
        this.c = context;
        if (this.f1224a != null && this.f1224a.length != 0) {
            this.b = LayoutInflater.from(this.c);
        }
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        if (this.f1224a == null) {
            return 0;
        }
        return this.f1224a.length;
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ForumDetailData.ThreadInfo threadInfo = this.f1224a[i];
        View inflate = this.b.inflate(R.layout.forum_detail_hot_thread_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.ht_item_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ht_item_content);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ht_item_pv);
        TextView textView4 = (TextView) inflate.findViewById(R.id.ht_item_reply);
        textView.setText(threadInfo.title);
        StringBuilder sb = new StringBuilder();
        int length = threadInfo.abstracts.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (threadInfo.abstracts[i2].type == 0) {
                sb.append(threadInfo.abstracts[i2].text);
            }
        }
        textView2.setText(sb.toString());
        textView3.setText(String.valueOf(threadInfo.viewNum));
        textView4.setText(String.valueOf(threadInfo.replyNum));
        if (TiebaApplication.g().as() == 1) {
            textView.setTextColor(this.c.getResources().getColor(R.color.forum_detail_htitem_title_color_1));
            textView2.setTextColor(this.c.getResources().getColor(R.color.forum_detail_brief_txt_color_1));
            textView3.setTextColor(this.c.getResources().getColor(R.color.forum_detail_htitem_tip_color_1));
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.c.getResources().getDrawable(R.drawable.icon_eye_1);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            textView3.setCompoundDrawables(bitmapDrawable, null, null, null);
            textView4.setTextColor(this.c.getResources().getColor(R.color.forum_detail_htitem_tip_color_1));
            BitmapDrawable bitmapDrawable2 = (BitmapDrawable) this.c.getResources().getDrawable(R.drawable.icon_comment_1);
            bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
            textView4.setCompoundDrawables(bitmapDrawable2, null, null, null);
        } else {
            textView.setTextColor(this.c.getResources().getColor(R.color.forum_detail_htitem_title_color));
            textView2.setTextColor(this.c.getResources().getColor(R.color.forum_detail_brief_txt_color));
            textView3.setTextColor(this.c.getResources().getColor(R.color.forum_detail_htitem_tip_color));
            BitmapDrawable bitmapDrawable3 = (BitmapDrawable) this.c.getResources().getDrawable(R.drawable.icon_eye);
            bitmapDrawable3.setBounds(0, 0, bitmapDrawable3.getIntrinsicWidth(), bitmapDrawable3.getIntrinsicHeight());
            textView3.setCompoundDrawables(bitmapDrawable3, null, null, null);
            textView4.setTextColor(this.c.getResources().getColor(R.color.forum_detail_htitem_tip_color));
            BitmapDrawable bitmapDrawable4 = (BitmapDrawable) this.c.getResources().getDrawable(R.drawable.icon_comment);
            bitmapDrawable4.setBounds(0, 0, bitmapDrawable4.getIntrinsicWidth(), bitmapDrawable4.getIntrinsicHeight());
            textView4.setCompoundDrawables(bitmapDrawable4, null, null, null);
        }
        inflate.setOnClickListener(new m(this, String.valueOf(threadInfo.id)));
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }
}
