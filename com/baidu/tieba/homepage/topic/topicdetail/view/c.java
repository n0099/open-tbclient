package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c extends m {
    private EditText fwL;

    public c(Context context) {
        super(context, (String) null, 29);
        this.fuW = false;
        this.fuV = 3;
        this.fub = new TopicDetaiInputContainer(context);
        this.fwL = ((TopicDetaiInputContainer) this.fub).getInputView();
        ((TopicDetaiInputContainer) this.fub).setHint(context.getString(R.string.say_your_point));
        this.fuX = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.fwL;
    }
}
