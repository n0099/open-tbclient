package com.baidu.tieba.frs.ar.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsArActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import tbclient.ForumArIno;
/* loaded from: classes3.dex */
public class b extends View {
    private AnimationDrawable byc;
    private ForumArIno dJn;
    private String forumName;

    public b(Context context) {
        super(context);
        init();
    }

    private void init() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_1), 100);
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_2), 100);
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_3), 100);
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_4), 100);
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_5), 100);
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_6), 100);
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_7), 100);
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_8), 100);
        animationDrawable.addFrame(getResources().getDrawable(d.f.frs_ar_entrance_anim_9), 100);
        this.byc = animationDrawable;
        setBackgroundDrawable(animationDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ar.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.dJn != null) {
                    ak akVar = new ak("c12836");
                    akVar.ab(ImageViewerConfig.FORUM_NAME, b.this.forumName == null ? "" : b.this.forumName);
                    akVar.s("obj_id", b.this.dJn.ar_id.intValue());
                    TiebaStatic.log(akVar);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsArActivityConfig(b.this.getContext(), b.this.forumName, String.valueOf(b.this.dJn.ar_id), String.valueOf(b.this.dJn.ar_type), b.this.dJn.title)));
                }
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Drawable drawable = getResources().getDrawable(d.f.frs_ar_entrance_anim_1);
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            setMeasuredDimension(bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public void awQ() {
        this.byc.start();
    }

    public void setForumArIno(ForumArIno forumArIno) {
        this.dJn = forumArIno;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
