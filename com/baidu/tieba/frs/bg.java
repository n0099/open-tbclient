package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1276a;
    final /* synthetic */ boolean b;
    final /* synthetic */ bf c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar, int i, boolean z) {
        this.c = bfVar;
        this.f1276a = i;
        this.b = z;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.frs_im_group_cover, (ViewGroup) null);
        ((com.baidu.tieba.j) this.c.f1275a).m().a(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.frs_chat_group_text_num_cover);
        TextView textView2 = (TextView) inflate.findViewById(R.id.frs_chat_group_text2_cover);
        if (textView != null && textView2 != null) {
            if (this.f1276a > 0) {
                textView.setText(String.valueOf(this.f1276a));
                textView.setVisibility(0);
                textView2.setVisibility(0);
            } else {
                textView.setText(SocialConstants.FALSE);
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
        }
        return inflate;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return this.b ? 351 : 250;
    }
}
