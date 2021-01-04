package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends m {
    private EditText fGr;

    public c(Context context) {
        super(context, (String) null, 29);
        this.fEC = false;
        this.fEB = 3;
        this.fDH = new TopicDetaiInputContainer(context);
        this.fGr = ((TopicDetaiInputContainer) this.fDH).getInputView();
        ((TopicDetaiInputContainer) this.fDH).setHint(context.getString(R.string.say_your_point));
        this.fED = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.fGr;
    }
}
