package com.baidu.tieba.frs.ar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsArActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import tbclient.ForumArIno;
/* loaded from: classes3.dex */
public class FrsAREntryView extends View {
    private AnimationDrawable aIC;
    private ForumArIno dcb;
    private String forumName;

    public FrsAREntryView(Context context) {
        super(context);
        init();
    }

    public FrsAREntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FrsAREntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.aIC = animationDrawable;
        setBackgroundDrawable(animationDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ar.view.FrsAREntryView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (FrsAREntryView.this.dcb != null) {
                    al alVar = new al("c12836");
                    alVar.ac(ImageViewerConfig.FORUM_NAME, FrsAREntryView.this.forumName == null ? "" : FrsAREntryView.this.forumName);
                    alVar.r(VideoPlayActivityConfig.OBJ_ID, FrsAREntryView.this.dcb.ar_id.intValue());
                    TiebaStatic.log(alVar);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsArActivityConfig(FrsAREntryView.this.getContext(), FrsAREntryView.this.forumName, String.valueOf(FrsAREntryView.this.dcb.ar_id), String.valueOf(FrsAREntryView.this.dcb.ar_type), FrsAREntryView.this.dcb.title)));
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

    public void ari() {
        this.aIC.start();
    }

    public void setForumArIno(ForumArIno forumArIno) {
        this.dcb = forumArIno;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }
}
