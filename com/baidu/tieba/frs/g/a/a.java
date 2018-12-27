package com.baidu.tieba.frs.g.a;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.frs.g.a<b> {
    private final View.OnClickListener enj;

    public a(@NonNull TbPageContext tbPageContext) {
        super(tbPageContext);
        this.enj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b item;
                if ((view.getTag() instanceof C0221a) && (item = a.this.getItem(((C0221a) view.getTag()).position)) != null && !TextUtils.isEmpty(item.aJo())) {
                    ay.Ef().a((TbPageContext<?>) a.this.aJB(), new String[]{item.aJo()}, true);
                }
            }
        };
    }

    @Override // com.baidu.tieba.frs.g.a
    protected View d(int i, View view, ViewGroup viewGroup) {
        C0221a c0221a;
        if (view == null) {
            C0221a c0221a2 = new C0221a();
            view = LayoutInflater.from(getContext()).inflate(e.h.frs_header_youhua_hot_content_item, viewGroup, false);
            c0221a2.bSa = view;
            c0221a2.enl = (TextView) view.findViewById(e.g.top_youhua_hot_thread_index);
            c0221a2.enm = (TextView) view.findViewById(e.g.top_youhua_hot_thread_sub_title);
            c0221a2.enn = (TextView) view.findViewById(e.g.top_youhua_hot_thread_content);
            c0221a2.eno = (TbImageView) view.findViewById(e.g.top_youhua_hot_thread_image);
            c0221a2.enp = (ImageView) view.findViewById(e.g.top_youhua_hot_thread_image_flag);
            c0221a2.divider = view.findViewById(e.g.top_item_divider);
            view.setTag(c0221a2);
            c0221a = c0221a2;
        } else {
            c0221a = (C0221a) view.getTag();
        }
        a(c0221a, i);
        return view;
    }

    private void a(@NonNull C0221a c0221a, int i) {
        b item = getItem(i);
        if (item != null) {
            c0221a.position = i;
            c0221a.enn.setText(bX(item.aJF()));
            String a = a(item);
            if (TextUtils.isEmpty(a)) {
                c0221a.enm.setVisibility(8);
            } else {
                c0221a.enm.setVisibility(0);
                c0221a.enm.setText(a);
            }
            if (TextUtils.isEmpty(item.aJC())) {
                c0221a.enp.setVisibility(8);
                c0221a.eno.setVisibility(8);
            } else {
                if (item.aJD()) {
                    c0221a.enp.setVisibility(0);
                } else {
                    c0221a.enp.setVisibility(8);
                }
                c0221a.eno.setVisibility(0);
                c0221a.eno.startLoad(item.aJC(), 10, false);
            }
            if (item.getRank() < 10) {
                c0221a.enl.setText("0" + item.getRank());
            } else {
                c0221a.enl.setText(String.valueOf(item.getRank()));
            }
            c0221a.divider.setVisibility(i == getCount() + (-1) ? 8 : 0);
            al.i(c0221a.bSa, e.f.home_thread_card_item_bg);
            al.h(c0221a.enn, e.d.cp_cont_b);
            al.h(c0221a.enm, e.d.cp_cont_d);
            al.h(c0221a.enl, oh(i));
            al.j(c0221a.divider, e.d.cp_bg_line_c);
            c0221a.bSa.setOnClickListener(this.enj);
        }
    }

    private String a(@NonNull b bVar) {
        if (TextUtils.isEmpty(bVar.getGroupName())) {
            return null;
        }
        return String.format(getContext().getResources().getString(e.j.frs_top_youhua_thread_subinfo), bVar.getGroupName(), Integer.valueOf(bVar.aJE()));
    }

    private CharSequence bX(List<PbContent> list) {
        boolean z;
        SpannableString spannableString;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (v.I(list)) {
            return spannableStringBuilder;
        }
        boolean z2 = false;
        for (PbContent pbContent : list) {
            if (c(pbContent)) {
                if (pbContent.type.intValue() == 3) {
                    SpannableString spannableString2 = new SpannableString(" ");
                    Drawable drawable = ContextCompat.getDrawable(getContext(), e.f.icon_card_link_n);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    spannableString2.setSpan(new ImageSpan(drawable, 0), 0, " ".length(), 33);
                    z = true;
                    spannableString = spannableString2;
                } else if (z2 && "网页链接".equals(pbContent.text)) {
                    spannableString = new SpannableString(pbContent.text);
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), e.d.frs_youhua_http_link)), 0, pbContent.text.length(), 33);
                    z = false;
                } else {
                    SpannableString spannableString3 = new SpannableString(pbContent.text);
                    z = z2;
                    spannableString = spannableString3;
                }
                spannableStringBuilder.append((CharSequence) spannableString);
                z2 = z;
            }
        }
        return spannableStringBuilder;
    }

    private int oh(int i) {
        int i2 = e.d.cp_cont_d;
        if (i == 0) {
            return e.d.frs_youhua_link_b;
        }
        if (i == 1) {
            return e.d.frs_youhua_link_g;
        }
        if (i == 2) {
            return e.d.frs_youhua_link_c;
        }
        return i2;
    }

    private boolean c(PbContent pbContent) {
        return (pbContent == null || pbContent.text == null) ? false : true;
    }

    /* renamed from: com.baidu.tieba.frs.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0221a {
        View bSa;
        View divider;
        TextView enl;
        TextView enm;
        TextView enn;
        TbImageView eno;
        ImageView enp;
        int position;

        public C0221a() {
        }
    }
}
