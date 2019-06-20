package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText csH;

    public c(Context context) {
        super(context, (String) null, 29);
        this.cry = false;
        this.crx = 3;
        this.cqF = new TopicDetaiInputContainer(context);
        this.csH = ((TopicDetaiInputContainer) this.cqF).getInputView();
        ((TopicDetaiInputContainer) this.cqF).setHint(context.getString(R.string.say_your_point));
        this.crz = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.csH;
    }
}
