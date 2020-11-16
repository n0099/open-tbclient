package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends m {
    private EditText fpg;

    public c(Context context) {
        super(context, (String) null, 29);
        this.fns = false;
        this.fnr = 3;
        this.fmx = new TopicDetaiInputContainer(context);
        this.fpg = ((TopicDetaiInputContainer) this.fmx).getInputView();
        ((TopicDetaiInputContainer) this.fmx).setHint(context.getString(R.string.say_your_point));
        this.fnt = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.fpg;
    }
}
