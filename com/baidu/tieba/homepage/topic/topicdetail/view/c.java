package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends m {
    private EditText ePB;

    public c(Context context) {
        super(context, (String) null, 29);
        this.eNN = false;
        this.eNM = 3;
        this.eMS = new TopicDetaiInputContainer(context);
        this.ePB = ((TopicDetaiInputContainer) this.eMS).getInputView();
        ((TopicDetaiInputContainer) this.eMS).setHint(context.getString(R.string.say_your_point));
        this.eNO = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.ePB;
    }
}
