package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText ckx;

    public c(Context context) {
        super(context, (String) null, 29);
        this.cjo = false;
        this.cjn = 3;
        this.ciw = new TopicDetaiInputContainer(context);
        this.ckx = ((TopicDetaiInputContainer) this.ciw).getInputView();
        ((TopicDetaiInputContainer) this.ciw).setHint(context.getString(d.j.say_your_point));
        this.cjp = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.ckx;
    }
}
