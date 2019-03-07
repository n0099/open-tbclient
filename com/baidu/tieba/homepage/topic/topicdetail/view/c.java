package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText ckv;

    public c(Context context) {
        super(context, (String) null, 29);
        this.cjm = false;
        this.cjl = 3;
        this.ciu = new TopicDetaiInputContainer(context);
        this.ckv = ((TopicDetaiInputContainer) this.ciu).getInputView();
        ((TopicDetaiInputContainer) this.ciu).setHint(context.getString(d.j.say_your_point));
        this.cjn = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.ckv;
    }
}
