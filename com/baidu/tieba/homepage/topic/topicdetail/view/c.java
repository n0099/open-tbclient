package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText cky;

    public c(Context context) {
        super(context, (String) null, 29);
        this.cjp = false;
        this.cjo = 3;
        this.cix = new TopicDetaiInputContainer(context);
        this.cky = ((TopicDetaiInputContainer) this.cix).getInputView();
        ((TopicDetaiInputContainer) this.cix).setHint(context.getString(d.j.say_your_point));
        this.cjq = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.cky;
    }
}
