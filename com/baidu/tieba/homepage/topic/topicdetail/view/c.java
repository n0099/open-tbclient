package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText cuY;

    public c(Context context) {
        super(context, (String) null, 29);
        this.ctO = false;
        this.ctN = 3;
        this.csV = new TopicDetaiInputContainer(context);
        this.cuY = ((TopicDetaiInputContainer) this.csV).getInputView();
        ((TopicDetaiInputContainer) this.csV).setHint(context.getString(R.string.say_your_point));
        this.ctP = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.cuY;
    }
}
