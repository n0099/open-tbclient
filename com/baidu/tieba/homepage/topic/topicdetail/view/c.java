package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends m {
    private EditText fBK;

    public c(Context context) {
        super(context, (String) null, 29);
        this.fzU = false;
        this.fzT = 3;
        this.fyZ = new TopicDetaiInputContainer(context);
        this.fBK = ((TopicDetaiInputContainer) this.fyZ).getInputView();
        ((TopicDetaiInputContainer) this.fyZ).setHint(context.getString(R.string.say_your_point));
        this.fzV = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.fBK;
    }
}
