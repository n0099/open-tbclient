package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText cGr;

    public c(Context context) {
        super(context, (String) null, 29);
        this.cFg = false;
        this.cFf = 3;
        this.cEn = new TopicDetaiInputContainer(context);
        this.cGr = ((TopicDetaiInputContainer) this.cEn).getInputView();
        ((TopicDetaiInputContainer) this.cEn).setHint(context.getString(R.string.say_your_point));
        this.cFh = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.cGr;
    }
}
